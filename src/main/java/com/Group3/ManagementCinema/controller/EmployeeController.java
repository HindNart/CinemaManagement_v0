package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Employee;
import com.Group3.ManagementCinema.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String showAllEmployees(Model model){
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewMovieForm(Model model) {
		// create model attribute to bind form data
		Employee Employee = new Employee();
		model.addAttribute("employee", Employee);
		return "employee_new";
	}
	@GetMapping("/searchEmployee")
	public String searchEmployee(@RequestParam("id") String id, Model model) {
		Employee Employee = employeeService.getEmployeeById(id);
		model.addAttribute("Employee", Employee);
		return "search_Employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save Employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdateEmployee/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		// get Employee from the service
		Employee Employee = employeeService.getEmployeeById(id);
		// set Employee as a model attribute to pre-populate the form
		model.addAttribute("Employee", Employee);
		return "update_Employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") String id) {
		// call delete Employee method
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	
}
