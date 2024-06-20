package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Group3.ManagementCinema.entity.Employee;
import com.Group3.ManagementCinema.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public String showEmployeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "employees"; // Trả về template adEmployee.html trong thư mục templates/admin/
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee_new";
    }

    @GetMapping("/searchEmployee")
    public String searchEmployee(@RequestParam("id") String id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employee_search";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdateEmployee/{id}")
    public String showFormForUpdateEmployee(@PathVariable(value = "id") String id, Model model) {
        // get employee from the service
        Employee employee = employeeService.getEmployeeById(id);
        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "employee_update";
    }
    
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") String id) {
        // call delete employee method
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
