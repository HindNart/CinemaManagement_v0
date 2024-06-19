package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Ticket;
import com.Group3.ManagementCinema.service.TicketService;

@Controller
public class TicketController {
	@Autowired
	private TicketService TicketService;
	
//	@GetMapping("/showCinemaRoom")
//	public String viewHomePage(Model model) {
//		model.addAttribute("listCinemaRooms", cinemaRoomService.getAllCinemaRooms());
//		return "cinemaRoom";
//	}
	
	@GetMapping("/showNewTicketForm")
	public String showNewTicketForm(Model model) {
		// create model attribute to bind form data
		Ticket Ticket = new Ticket();
		model.addAttribute("Ticket",  Ticket);
		return "ticketRoom_new";
	}
	
	@GetMapping("/searchTicketRoom")
	public String searchTicket(@RequestParam("id") String id, Model model) {
		Ticket Ticket = TicketService.getTicketById(id);
		model.addAttribute("Ticket", Ticket);
		return "Ticket_search";
	}
	
	@PostMapping("/saveTicket")
	public String saveTicket(@ModelAttribute("Ticket") Ticket Ticket) {
		TicketService.saveTicket(Ticket);
		return "redirect:/showTicket";
	}
	
	@GetMapping("/showFormForUpdateTicket/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		Ticket Ticket = TicketService.getTicketById(id);
		model.addAttribute("Ticket", Ticket);
		return "Ticket_update";
	}
	
	@GetMapping("/deleteTicket/{id}")
	public String deleteTicket(@PathVariable(value = "id") String id) {
		this.TicketService.deleteTicketById(id);
		return "redirect:/";
	}
}