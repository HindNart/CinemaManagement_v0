package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.service.MovieService;



@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;// display list of movies
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listMovies", movieService.getAllMovies());
		return "index";
	}
	
	@GetMapping("/showNewMovieForm")
	public String showNewMovieForm(Model model) {
		// create model attribute to bind form data
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "new_movie";
	}
	
	@GetMapping("/searchMovie")
	public String searchMovie(@RequestParam("id") String id, Model model) {
		Movie movie = movieService.getMovieById(id);
		model.addAttribute("movie", movie);
		return "search_movie";
	}
	
	@PostMapping("/saveMovie")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		// save movie to database
		movieService.saveMovie(movie);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		// get movie from the service
		Movie movie = movieService.getMovieById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		return "update_movie";
	}
	
	@GetMapping("/deleteMovie/{id}")
	public String deleteMovie(@PathVariable(value = "id") String id) {
		// call delete movie method
		this.movieService.deleteMovieById(id);
		return "redirect:/";
	}
}
