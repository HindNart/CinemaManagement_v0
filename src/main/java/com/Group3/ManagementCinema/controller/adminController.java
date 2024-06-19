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
import com.Group3.ManagementCinema.service.MovieService;

@Controller
@RequestMapping("/admin")
public class adminController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CinemaRoomService cinemaroomService;
    @Autowired
    private MovieService movieService;

    // Hiển thị danh sách khách hàng
    @GetMapping("/adCustomer.html")
    public String showCustomerList(Model model) {
        model.addAttribute("listCustomers", customerService.getAllCustomers());
        return "admin/adCustomer"; // Trả về template adCustomer.html trong thư mục templates/admin/
    }
    
    @GetMapping("/adEmployee.html")
    public String showEmployeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "admin/adEmployee"; // Trả về template adEmployee.html trong thư mục templates/admin/
    }
    
    @GetMapping("/adMovie.html")
    public String showMovieList(Model model) {
        model.addAttribute("listMovies", movieService.getAllMovies());
        return "admin/adMovie"; // Trả về template adMovie.html trong thư mục templates/admin/
    }
    
    @GetMapping("/adRoom.html")
    public String showRoomList(Model model) {
        model.addAttribute("listCinemaRooms", cinemaroomService.getAllCinemaRooms());
        return "admin/adRoom"; // Trả về template adRoom.html trong thư mục templates/admin/
    }
}

