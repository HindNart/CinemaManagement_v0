package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.service.CinemaRoomService;
import com.Group3.ManagementCinema.service.CustomerService;
import com.Group3.ManagementCinema.service.EmployeeService;
import com.Group3.ManagementCinema.service.MovieScheduleService;
import com.Group3.ManagementCinema.service.MovieService;

@Controller
public class adminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CinemaRoomService cinemaroomService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieScheduleService moviescheduleService;
    @GetMapping("/")
    public String countCustomers(Model model) {
        long customerCount = customerService.countCustomers();
        model.addAttribute("customerCount", customerCount);
	    long cinemaRoomCount = cinemaroomService.countCinemaRoom();
	    model.addAttribute("cinemaRoomCount", cinemaRoomCount);
	    long employeeCount = employeeService.countEmployee();
	    model.addAttribute("employeeCount", employeeCount);
        long movieCount = movieService.countMovie();
        model.addAttribute("movieCount", movieCount);	
        long movieScheduleCount = moviescheduleService.countMovieSchedule();
        model.addAttribute("movieScheduleCount", movieScheduleCount);	
        return "index.html";  // Trả về tên view (index)
    }
}

