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
    private MovieScheduleService moviescheduleService;

    // Hiển thị danh sách khách hàng
    @GetMapping("/adCustomer.html")
    public String showCustomerList(Model model) {
        model.addAttribute("listCustomer", customerService.getAllCustomers());
        return "admin/adCustomer"; // Trả về template adCustomer.html trong thư mục templates/admin/
    }
    
    @GetMapping("/adEmployee.html")
    public String showEmployeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "admin/adEmployee"; // Trả về template adCustomer.html trong thư mục templates/admin/
    }
    
    @GetMapping("/adRoom.html")
    public String showRoomList(Model model) {
        model.addAttribute("listCinemaRoom", cinemaroomService.getAllCinemaRooms());
        return "admin/adRoom"; // Trả về template adCustomer.html trong thư mục templates/admin/
    }
    @GetMapping("/adSchedule.html")
    public String showScheduleList(Model model) {
        model.addAttribute("listSchedule", moviescheduleService.getAllMovieSchedules());
        return "admin/adSchedule"; // Trả về template adCustomer.html trong thư mục templates/admin/
    }
}

