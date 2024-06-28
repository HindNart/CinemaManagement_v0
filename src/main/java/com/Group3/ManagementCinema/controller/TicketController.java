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
import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.ChairService;
import com.Group3.ManagementCinema.service.CinemaRoomService;
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
		List<Chair> chair = ticket.getGhe();
		model.addAttribute("ticket", ticket);
		return "/ticket/qrCode";
	}
	
	@GetMapping("/searchTicketById/{id}")
	public String searchTicketById(@PathVariable(value = "id") Long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "/ticket/ticket";
	}
	
	@PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		
		Ticket newTicket = ticketService.saveTicket(ticket);
		List<Chair> chair = ticket.getGhe();
		for (Chair c : chair) {
			c.setTrangThai(0);
		}
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
	public String viewHomePage(@PathVariable(value = "id") String id, HttpServletRequest request, Model model) {
	    // Lấy thông tin lịch chiếu, phòng chiếu và phim
	    MovieSchedule sche = moviescheduleService.getMovieScheduleById(id);
	    CinemaRoom room = cinemaroomService.getCinemaRoomById(sche.getPhongChieu().getIdPhong());
	    Movie movie = movieService.getMovieById(sche.getPhim().getIdPhim());
	    List<Chair> chair = chairService.findAllByIdPhong(room);
	    // Lấy đối tượng account từ session
	    HttpSession session = request.getSession();
	    Account account = (Account) session.getAttribute("account");
	    Ticket ticket = new Ticket();
	    ticket.setLichChieu(sche);
	    ticket.setTaiKhoan(account);
	    if (account == null) {
	        // Nếu không có account trong session, chuyển hướng đến trang đăng nhập
	        return "redirect:/login";
	    }
	    
	    // Thêm các thông tin vào model
	    model.addAttribute("account", account);
	    model.addAttribute("sche", sche);
	    model.addAttribute("movie", movie);
	    model.addAttribute("cinemaRoom", room);
	    model.addAttribute("chairs", chair);	    
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
