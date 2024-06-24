package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.service.ChairService;


@Controller
public class ChairController {
	@Autowired
	private ChairService chairService;// display list of movies
	
	@GetMapping("/chair")
	public String viewchair(Model model) {
		model.addAttribute("listchair", chairService.getAllChair());
		return "/chair/chair";
	}
	
	@GetMapping("/searchchair")
	public String searchMovieSchedule(@RequestParam("id") int id, Model model) {
		Chair chair = chairService.getChairById(id);
		model.addAttribute("chair", chair);
		return "/chair/chair_search";
	}
	
	@PostMapping("/saveChair")
	public String saveChair(@ModelAttribute("chair") Chair chair) {
		// save movie to database
		chairService.saveChair(chair);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateChair/{id}")
	public String showFormForUpdateChair(@PathVariable(value = "id") int id, Model model) {
		// get movie from the service
		Chair chair = chairService.getChairById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("chair", chair);
		return "/chair/chair_update";
	}
	
	@GetMapping("/deleteChair/{id}")
	public String deleteChair(@PathVariable(value = "id") int id) {
		// call delete movie method
		this.chairService.deleteChair(id);
		return "redirect:/";
	}
}
