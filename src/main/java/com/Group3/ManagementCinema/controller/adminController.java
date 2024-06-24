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

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.service.AccountService;
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
    @Autowired
    private AccountService accountService;
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
        long accountCount = accountService.countAccount();
        model.addAttribute("accountCount", accountCount);	
        return "index.html";  // Trả về tên view (index)
    }
    @GetMapping("/login")
    public String openLogin(Model model) {
    	return "/login/login";
    }
    @GetMapping("/regis")
    public String openRegis(Model model) {
    	model.addAttribute("account", new Account());
    	return "/register/register";
    }
    @GetMapping("/checkLogin")
	public String checkLogin(@RequestParam("email") String email, Model model) {
		Account account = accountService.checkLogin(email);
		if (email.equals("admin@gmail.com")){
			return "/index";
		}
		if (accountService.checkLogin(email)!=null){
			model.addAttribute("account", account);
			return "/cusIndex";	
		}else {
			Boolean errorMss = true;
			model.addAttribute("errorMss", errorMss);
			model.addAttribute("account", account);
			return "/cusIndex";	
		}
	}
}

