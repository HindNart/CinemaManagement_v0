package com.Group3.ManagementCinema.controller;

import java.util.List;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.ChairService;
import com.Group3.ManagementCinema.service.CinemaRoomService;
import com.Group3.ManagementCinema.service.CustomerService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.MovieService;
import com.Group3.ManagementCinema.service.TicketService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private MovieService movieService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ChairService chairService;// display list of movies
	@Autowired
	private MovieScheduleService moviescheduleService;
	@Autowired
	private CinemaRoomService cinemaroomService;

	@GetMapping("/tickets")
	public String viewTicket(Model model) {
		model.addAttribute("listTickets", ticketService.getAllTickets());
		return "";
	}

	@GetMapping("/showNewTicketForm")
	public String showNewTicketForm(Model model) {
		// create model attribute to bind form data
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "/ticket/ticket_new";
	}

	@GetMapping("/qrTicket/{id}")
	public String qrTicket(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);

		model.addAttribute("ticket", ticket);
		return "/ticket/qrCode";
	}

	@GetMapping("/searchTicketById/{id}")
	public String searchTicketById(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		Chair chair = ticket.getGhe();
		model.addAttribute("chairs", chair);
		model.addAttribute("ticket", ticket);
		return "/ticket/ticket";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket, HttpServletRequest request) {
		
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

		return "redirect:/qrTicket/" + newTicket.getIdVe();
	}

	@PostMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.saveTicket(ticket);

		return "";
	}

	@GetMapping("/showFormForUpdateTicket/{id}")
	public String showFormForUpdateTicket(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}

	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") Long id) {
		this.ticketService.deleteTicketById(id);
		return "";
	}

	@GetMapping("/showBuyTicket/{id}")
	public String viewHomePage(@PathVariable(value = "id") Long id, HttpServletRequest request, Model model) {
		// Lấy thông tin lịch chiếu, phòng chiếu và phim
		MovieSchedule sche = moviescheduleService.getMovieScheduleById(id);
		CinemaRoom room = cinemaroomService.getCinemaRoomById(sche.getPhongChieu().getIdPhong());
		Movie movie = movieService.getMovieById(sche.getPhim().getIdPhim());
		List<Chair> chairs = chairService.findAllByIdPhong(room);
		// Lấy đối tượng account từ session
		
//		List<Ticket> tickets = ticketService.getAllTickets();
//		
//		for (Ticket check_ticket : tickets) {
//			MovieSchedule check_sche = check_ticket.getLichChieu();
//			CinemaRoom check_room = cinemaroomService.getCinemaRoomById(check_sche.getPhongChieu().getIdPhong());
//			for (Chair check_chair : chairs) {
//				if(check_ticket.getGhe().equals(check_chair)) {
//					if(check_room.getIdPhong().equals(check_chair.getIdPhong().getIdPhong())) {
//						check_chair.setTrangThai(0);
//					}
//				}
//			}
//		}
		
		List<Ticket> check_tickets = ticketService.findByLichChieu(sche);
		CinemaRoom check_room = cinemaroomService.getCinemaRoomById(sche.getPhongChieu().getIdPhong());
		chairs = chairService.findAllByIdPhong(check_room);
		for (Chair check_chair : chairs) {
			for (Ticket check_ticket : check_tickets) {
				if (check_chair.getIdGhe() == check_ticket.getGhe().getIdGhe()) {
					check_chair.setTrangThai(0);
				}
			}
		}
		
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		Customer customer = customerService.getCustomerById(account.getCustomer().getIdKhach());
		Ticket ticket = new Ticket();
		ticket.setIdLichChieu(sche);
		ticket.setTaiKhoan(account);
		
		if (account == null) {
			// Nếu không có account trong session, chuyển hướng đến trang đăng nhập
			return "redirect:/login";
		}

		// Thêm các thông tin vào model
		model.addAttribute("account", account);
		model.addAttribute("customer", customer);
		model.addAttribute("sche", sche);
		model.addAttribute("movie", movie);
		model.addAttribute("cinemaRoom", room);
		model.addAttribute("chairs", chairs);
		model.addAttribute("ticket", ticket);
		return "buyticket";
	}

	@GetMapping("/qrcode/{id}")
	public void generateQRCode(@PathVariable(value = "id") String id, HttpServletResponse response) throws IOException {
		String url = "localhost:8080/searchTicketById/" + id;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix;
		try {
			bitMatrix = qrCodeWriter.encode(url, BarcodeFormat.QR_CODE, 200, 200);
		} catch (WriterException e) {
			throw new IOException("Could not generate QR Code", e);
		}
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());

	}
}
