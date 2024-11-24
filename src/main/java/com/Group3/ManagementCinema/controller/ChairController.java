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

import com.Group3.ManagementCinema.entity.Chair;
import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.service.ChairService;
import com.Group3.ManagementCinema.service.CinemaRoomService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.MovieService;


@Controller
public class ChairController {
	@Autowired
	private ChairService chairService;// display list of movies
    @Autowired
    private MovieScheduleService moviescheduleService;
    @Autowired
    private CinemaRoomService cinemaroomService;
    @Autowired
    private MovieService movieService;
	@GetMapping("/newChair")
	public String newChair(Model model) {
		Chair chair = new Chair();
		model.addAttribute("chair",chair);
		return "/chair/chair_new";
	}
	
	
	@GetMapping("/searchchair")
	public String searchMovieSchedule(@RequestParam("id") Long id, Model model) {
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
	public String showFormForUpdateChair(@PathVariable(value = "id") Long id, Model model) {
		// get movie from the service
		Chair chair = chairService.getChairById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("chair", chair);
		return "/chair/chair_update";
	}
	
	@GetMapping("/deleteChair/{id}")
	public String deleteChair(@PathVariable(value = "id") Long id) {
		// call delete movie method
		this.chairService.deleteChair(id);
		return "redirect:/";
	}
	
	@GetMapping("/addChair")
	public String addChair() {
		// save movie to database
		CinemaRoom cineRoom = cinemaroomService.getCinemaRoomById("pc4");
		
		for(int i = 1; i < 9; i++) {
			Chair chair = new Chair();
			chair.setGiaGhe(120000);
			chair.setHangGhe("D");
			chair.setIdPhong(cineRoom);
			chair.setTrangThai(1);
			chair.setLoaiGhe("Couple");
			chair.setGheSo(i);
			chairService.saveChair(chair);
		}
		
		
		return "redirect:/";
	}
	
}
