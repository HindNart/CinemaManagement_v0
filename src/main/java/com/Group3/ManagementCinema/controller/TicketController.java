package com.Group3.ManagementCinema.controller;

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
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private MovieScheduleService movieScheduleService;
	@Autowired
	private AccountService accountService;
	
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
	public String searchTicketById(@RequestParam("id") String id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}
	
	@PostMapping("/saveTicket")
    public String saveTicket(@ModelAttribute("ticket") Ticket ticket, RedirectAttributes redirectAttributes) {
		Ticket existTicket = ticketService.getTicketById(ticket.getIdVe());
		MovieSchedule existMovieSchedule = null;
		Account existAccount = null;
		if (existTicket == null) {
			try {
				existMovieSchedule = movieScheduleService.getMovieScheduleById(ticket.getLichChieu().getIdLichChieu());
				existAccount = accountService.getAccountById(ticket.getTaiKhoan().getEmail());	
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (existMovieSchedule == null) {
	    		redirectAttributes.addFlashAttribute("message", "Thêm vé thất bại. Lịch chiếu không tồn tại!");
	    	} else if (existAccount == null) {
	    		redirectAttributes.addFlashAttribute("message", "Thêm vé thất bại!");
			} else if (existMovieSchedule != null && existAccount != null) {
				ticketService.saveTicket( 
	        			ticket.getIdVe(),
	        			ticket.getLichChieu().getIdLichChieu(),
	        			ticket.getTaiKhoan().getEmail(),
			            ticket.getGia(),
			            ticket.getThoigianMua());
	            redirectAttributes.addFlashAttribute("message", "Thêm vé thành công!");
	        }
		}
		else {
        	redirectAttributes.addFlashAttribute("message", "Thêm vé thất bại. Vé đã tồn tại!");
        }
        return "";
    }
	
	@PostMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket ticket, Model model) {
		ticketService.saveTicket(ticket);
		return "";
	}		
	
	@GetMapping("/showFormForUpdateTicket/{id}")
	public String showFormForUpdateTicket(@PathVariable(value = "id") String id, Model model) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		return "";
	}
	
	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") String id) {
		this.ticketService.deleteTicketById(id);
		return "";
	}
}
