package com.Group3.ManagementCinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "";
    } 
	
	@GetMapping("/searchTicketById")
	public String searchTicketById(@RequestParam("id") long id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}
	
	@PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket, RedirectAttributes redirectAttributes) {
		ticketService.saveTicket( 
	        			ticket.getIdVe(),
	        			ticket.getLichChieu().getIdLichChieu(),
	        			ticket.getTaiKhoan().getEmail(),
			            ticket.getGia(),
			            ticket.getThoigianMua()
			          	);	        
        return "index";
    }
	
	@PostMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.saveTicket(ticket);
		return "";
	}		
	
	@GetMapping("/showFormForUpdateTicket/{id}")
	public String showFormForUpdateTicket(@PathVariable(value = "id") int id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}
	
	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") int id) {
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

	
}
