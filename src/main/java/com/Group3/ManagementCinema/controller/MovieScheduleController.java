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

import com.Group3.ManagementCinema.entity.CinemaRoom;
import com.Group3.ManagementCinema.entity.Movie;
import com.Group3.ManagementCinema.entity.MovieSchedule;
import com.Group3.ManagementCinema.repository.MovieRepository;
import com.Group3.ManagementCinema.service.CinemaRoomService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.MovieService;


@Controller
public class MovieScheduleController {
	@Autowired
	private MovieScheduleService movieScheduleService;// display list of movies
	@Autowired
	private MovieService movieService;
	@Autowired
	private CinemaRoomService cinemaRoomService;
	
	@GetMapping("/movieSchedules")
	public String viewMovieSchedule(Model model) {
		model.addAttribute("listMovieSchedules", movieScheduleService.getAllMovieSchedules());
		return "/movieSchedule/movieSchedules";
	}
	
	@GetMapping("/showNewMovieScheduleForm")
    public String showNewMovieScheduleForm(Model model) {
        // create model attribute to bind form data
        MovieSchedule movieSchedule = new MovieSchedule();
		List<Movie> movie = movieService.getAllMovies();
		List<CinemaRoom> cinemaRoom = cinemaRoomService.getAllCinemaRooms();
		model.addAttribute("cinemaRooms", cinemaRoom);
		model.addAttribute("movies", movie);
        model.addAttribute("movieSchedule", movieSchedule);
        return "/movieSchedule/movieSchedule_new";
    } 
	
	@GetMapping("/searchMovieSchedule")
	public String searchMovieSchedule(@RequestParam("id") String id, Model model) {
		List<MovieSchedule> movieSchedule = movieScheduleService.findMovieSchedulesByMovieName(id);
		model.addAttribute("movieSchedule", movieSchedule);
		return "/movieSchedule/movieSchedule_search";
	}
	
	@PostMapping("/saveMovieSchedule")
	public String saveMovieSchedule(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, Model model) {
		if (movieScheduleService.checkMS(movieSchedule.getNgayChieu(),  movieSchedule.getThoigianBD(),  movieSchedule.getThoigianKT(), movieSchedule.getPhongChieu()) != null) {
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
	
	@PostMapping("/updateMovieSchedule")
	public String updateRate(@ModelAttribute("movieSchedule") MovieSchedule movieSchedule, Model model) {
		movieScheduleService.saveMovieSchedule(movieSchedule);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateMovieSchedule/{id}")
	public String showFormForUpdateSchedule(@PathVariable(value = "id") String id, Model model) {
		// get movie from the service
		MovieSchedule movieSchedule = movieScheduleService.getMovieScheduleById(id);
		// set movie as a model attribute to pre-populate the form
		List<Movie> movie = movieService.getAllMovies();
		List<CinemaRoom> cinemaRoom = cinemaRoomService.getAllCinemaRooms();
		model.addAttribute("cinemaRooms", cinemaRoom);
		model.addAttribute("movies", movie);
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
