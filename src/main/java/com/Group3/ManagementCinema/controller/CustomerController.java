package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;// display list of movies
	
	@GetMapping("/showCus")
	public String viewHomePage(Model model) {
		model.addAttribute("listCustomer", customerService.getAllCustomers());
		return "indexCus";
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "cusNew";
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("id") String id, Model model) {
		Customer customer = customerService.getCustomerById(id);
		model.addAttribute("movie", customer);
		return "cusSearch";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save movie to database
		customerService.saveCustomer(customer);
		return "redirect:/showCus";
	}
	
	@GetMapping("/showFormForUpdateCustomer/{id}")
	public String showFormForUpdateUpdate(@PathVariable(value = "id") String id, Model model) {
		// get movie from the service
		Customer customer = customerService.getCustomerById(id);
		// set movie as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		return "cusUpdate";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") String id) {
		// call delete movie method
		this.customerService.deleteCustomerById(id);
		return "redirect:/showCus";
	}
}
