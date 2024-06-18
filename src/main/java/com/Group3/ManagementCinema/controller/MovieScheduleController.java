package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.service.MovieScheduleService;


@Controller
public class MovieScheduleController {
	@Autowired
	private MovieScheduleService movieScheduleService;// display list of movies
	
	@GetMapping("/movieSchedule")
	public String viewMovieSchedule(Model model) {
		model.addAttribute("listMovieSchedule", movieScheduleService.getAllMovieSchedules());
		return "movieSchedule";
	}
	
	@GetMapping("/searchMovieSchedule")
	public String searchMovieSchedule(@RequestParam("id") String id, Model model) {
		MovieSchedule movieSchedule = movieScheduleService.getMovieScheduleById(id);
		model.addAttribute("movieSchedule", movieSchedule);
		return "movieSchedule_search";
	}
	
	@PostMapping("/saveMovieSchedule")
	public String saveMovieSchedule(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule) {
		// save movie to database
		movieScheduleService.saveMovieSchedule(movieSchedule);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateMovieSchedule/{id}")
	public String showFormForUpdateSchedule(@PathVariable(value = "id") String id, Model model) {
		// get movie from the service
		MovieSchedule movieSchedule = movieScheduleService.getMovieScheduleById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movieSchedule", movieSchedule);
		return "movieSchedule_update";
	}
	
	@GetMapping("/deleteMovieSchedule/{id}")
	public String deleteMovieSchedule(@PathVariable(value = "id") String id) {
		// call delete movie method
		this.movieScheduleService.deleteMovieScheduleById(id);
		return "redirect:/";
	}
}
