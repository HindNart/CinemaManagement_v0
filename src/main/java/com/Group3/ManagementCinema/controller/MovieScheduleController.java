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
	
	@GetMapping("/movieSchedules")
	public String viewMovieSchedule(Model model) {
		model.addAttribute("listMovieSchedules", movieScheduleService.getAllMovieSchedules());
		return "/movieSchedule/movieSchedules";
	}
	
	@GetMapping("/showNewMovieScheduleForm")
    public String showNewMovieScheduleForm(Model model) {
        // create model attribute to bind form data
        MovieSchedule movieSchedule = new MovieSchedule();
        model.addAttribute("movieSchedule", movieSchedule);
        return "/movieSchedule/movieSchedule_new";
    } 
	
	@GetMapping("/searchMovieSchedule")
	public String searchMovieSchedule(@RequestParam("id") String id, Model model) {
		MovieSchedule movieSchedule = movieScheduleService.getMovieScheduleById(id);
		model.addAttribute("movieSchedule", movieSchedule);
		return "/movieSchedule/movieSchedule_search";
	}
	
	@PostMapping("/saveMovieSchedule")
	public String saveMovieSchedule(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, Model model) {
		if (movieScheduleService.checkMS(movieSchedule.getNgayChieu(),  movieSchedule.getThoigianBD(),  movieSchedule.getThoigianKT()) != null) {
			model.addAttribute("exists", true);
			return "movieSchedule/movieSchedule_new";
		}else {
			movieScheduleService.saveMovieSchedule( 
					movieSchedule.getIdLichChieu(),
		            movieSchedule.getPhongChieu().getIdPhong(),
		            movieSchedule.getPhim().getIdPhim(),
		            movieSchedule.getThoigianBD(),
		            movieSchedule.getThoigianKT(),
		            movieSchedule.getNgayChieu());
			return "redirect:/";
		}		
	}
	
	@GetMapping("/showFormForUpdateMovieSchedule/{id}")
	public String showFormForUpdateSchedule(@PathVariable(value = "id") String id, Model model) {
		// get movie from the service
		MovieSchedule movieSchedule = movieScheduleService.getMovieScheduleById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movieSchedule", movieSchedule);
		return "/movieSchedule/movieSchedule_update";
	}
	
	@GetMapping("/deleteMovieSchedule/{id}")
	public String deleteMovieSchedule(@PathVariable(value = "id") String id) {
		// call delete movie method
		this.movieScheduleService.deleteMovieScheduleById(id);
		return "redirect:/";
	}
}
