package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.service.CinemaRoomService;

@Controller
public class CinemaRoomController {
	@Autowired
	private CinemaRoomService cinemaRoomService;
	
	@GetMapping("/showCinemaRoom")
	public String viewHomePage(Model model) {
		model.addAttribute("listCinemaRooms", cinemaRoomService.getAllCinemaRooms());
		return "/cinemaRoom/cinemaRoom";
	}
	
	@GetMapping("/showNewCinemaRoomForm")
	public String showNewMovieForm(Model model) {
		// create model attribute to bind form data
		CinemaRoom cinemaRoom = new CinemaRoom();
		model.addAttribute("cinemaRoom",  cinemaRoom);
		return "/cinemaRoom/cinemaRoom_new";
	}
	
//	@GetMapping("/searchCinemaRoom")
//	public String searchCinemaRoom(@RequestParam("id") String id, Model model) {
//		model.addAttribute("cinemaRoom", cinemaRoomService.getCinemaRoomById(id));
//		return "cinemaRoom_search";
//	}
	
	@GetMapping("/searchCinemaRoom")
	public String searchCinemaRoom(@RequestParam("id") String id, Model model) {
		model.addAttribute("cinemaRoom", cinemaRoomService.findCinemaRoom(id));
		return "/cinemaRoom/cinemaRoom_search";
	}
	
	@PostMapping("/saveCinemaRoom")
	public String saveCinemaRoom(@ModelAttribute("cinemaRoom") CinemaRoom cinemaRoom) {
		cinemaRoomService.saveCinemaRoom(cinemaRoom);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateCinemaRoom/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		CinemaRoom cinemaRoom = cinemaRoomService.getCinemaRoomById(id);
		model.addAttribute("cinemaRoom", cinemaRoom);
		return "/cinemaRoom/cinemaRoom_update";
	}
	
	@GetMapping("/deleteCinemaRoom/{id}")
	public String deleteCinemaRoom(@PathVariable(value = "id") String id) {
		this.cinemaRoomService.deleteCinemaRoomById(id);
		return "redirect:/";
	}
}
