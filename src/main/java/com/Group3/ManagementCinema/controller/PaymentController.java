package com.Group3.ManagementCinema.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.ChairService;
import com.Group3.ManagementCinema.service.TicketService;

import VNPayConfig.Config;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class PaymentController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private ChairService chairService;
	@Autowired
	private AccountService accountService;

	@PostMapping("/create_pay")
	public void getPay(@ModelAttribute("ticket") Ticket ticket, @RequestParam("amount") long amount, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException, IOException{
		
		// Lưu đối tượng ticket vào session
	    session.setAttribute("ticket", ticket);
		
		String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        long vnpAmount = amount * 100; 
        String bankCode = "NCB";
        
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";
        String vnp_TmnCode = Config.vnp_TmnCode;
        
        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(vnpAmount));
        vnp_Params.put("vnp_CurrCode", "VND");
        
        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);

        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);
        
        cld.add(Calendar.MINUTE, 15);
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);
        
        List fieldNames = new ArrayList(vnp_Params.keySet());
        Collections.sort(fieldNames);
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) vnp_Params.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                //Build hash data
                hashData.append(fieldName);
                hashData.append('=');
                hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                //Build query
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                query.append('=');
                query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                if (itr.hasNext()) {
                    query.append('&');
                    hashData.append('&');
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = Config.hmacSHA512(Config.vnp_HashSecret , hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
		
//        return "redirect:" + paymentUrl;
        response.sendRedirect(paymentUrl);
	}
	
//	@GetMapping("/return")
//    public String handleReturn(@ModelAttribute("ticket") Ticket ticket, HttpServletRequest request) {
////        boolean isValid = VNPayUtils.verifyParams(params, hashSecret);
//		boolean isValid = true;
//        if (isValid) {
//            return "Thanh toán thành công!";
//        } else {
//            return "Thanh toán thất bại!";
//        }
//    }
	
	@GetMapping("/return")
	public void saveTicket(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Lấy đối tượng ticket từ session
	    Ticket ticket = (Ticket) session.getAttribute("ticket");
	    
//	    if (ticket == null) {
//	        return "redirect:/error"; // Nếu không có ticket trong session, trả về lỗi
//	    }
	    
		String usePoints = request.getParameter("usePoints");
		boolean usePointsChecked = (usePoints != null && usePoints.equals("on"));

		// Lưu vé và nhận đối tượng vé mới
		Ticket newTicket = ticketService.saveTicket(ticket);

		// Đặt lại trạng thái của ghế
		Chair chairs = ticket.getGhe();
		chairService.saveChair(chairs); // Lưu trạng thái ghế

		// Xử lý logic điểm
		Account acc = ticket.getTaiKhoan();
		Customer customer = acc.getCustomer();
		
		if (usePointsChecked) {
			// Nếu được chọn sử dụng điểm, đặt điểm của tài khoản về 0
			customer.setDiem(0);
		} else {
			// Nếu không được chọn, cập nhật điểm (ví dụ: thêm 1000 điểm cho mỗi ghế)
			int currentPoints = customer.getDiem();
			int pointsToAdd = 1000; // Giả sử thêm 1000 điểm cho mỗi ghế
			customer.setDiem(currentPoints + pointsToAdd);
		}

		// Lưu các thay đổi vào tài khoản
		accountService.saveAccount(acc);

		// Lưu vé lại để đảm bảo tất cả các thay đổi được lưu
		ticketService.saveTicket(ticket);

//		return "redirect:/qrTicket/" + newTicket.getIdVe();
		response.sendRedirect("http://localhost:8080/qrTicket/" + newTicket.getIdVe());
	}
}