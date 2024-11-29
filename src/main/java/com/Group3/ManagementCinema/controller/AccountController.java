package com.Group3.ManagementCinema.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Customer;
import com.Group3.ManagementCinema.service.AccountService;
import com.Group3.ManagementCinema.service.CustomerService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;
	 @GetMapping("/showAllAccount")
	    public String showEmployeeList(Model model) {
	        model.addAttribute("listAccounts", accountService.getAllAccounts());
	        return "account/accounts"; // Trả về template adEmployee.html trong thư mục templates/admin/
	    }
	
	@GetMapping("/showNewAccountForm")
	public String showNewAccountForm(Model model) {
		// create model attribute to bind form data
		Account account = new Account();
		model.addAttribute("account",  account);
		return "/login/register.html";
	}
	
	@GetMapping("/searchAccount")
	public String searchAccount(@RequestParam("id") String id, Model model) {
		model.addAttribute("account", accountService.findAccount(id));
		return "account/account_search";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account account, Model model) {
		if (accountService.getAccountById(account.getEmail()) != null) {
			model.addAttribute("exists", true);
		}else {
			accountService.saveAccount(account);
			model.addAttribute("successMessage", "Đăng ký thành công!");
		}
		return "register/register";
	}
	@PostMapping("/updateAccount")
    public String updateAccount(@ModelAttribute("account") Account account) {
        // Lưu thông tin tài khoản
        accountService.saveAccount(account);
        
        // Trả về 200 OK để biết rằng cập nhật thành công
        return "redirect:/userSite";
    }
	
	@PostMapping("/updateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer) {
        // Lưu thông tin tài khoản
        customerService.saveCustomer(customer);        
        // Trả về 200 OK để biết rằng cập nhật thành công
        return "redirect:/userSite";
    }
	
	
	@PostMapping("/adUpdateAccount")
    public String adUpdateAccount(@ModelAttribute("account") Account account) {
        accountService.saveAccount(account);
        return "redirect:/";
    }
	
	@GetMapping("/showFormForUpdateAccount/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		Account account = accountService.getAccountById(id);
		model.addAttribute("account", account);
		return "account/account_update";
	}
	
	@GetMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable(value = "id") String id) {
		this.accountService.deleteAccountById(id);
		return "redirect:/";
	}
}
