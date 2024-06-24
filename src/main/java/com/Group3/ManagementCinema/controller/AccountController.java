package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.service.AccountService;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
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
		return "account_search";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("account") Account account, Model model) {
		if (accountService.checkLogin(account.getEmail()) != null) {
			model.addAttribute("exists", true);
		}else {
			accountService.saveAccount(account);
			model.addAttribute("successMessage", "Đăng ký thành công!");
		}
		return "register/register";
	}
	
	@GetMapping("/showFormForUpdateAccount/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
		Account account = accountService.getAccountById(id);
		model.addAttribute("account", account);
		return "account_update";
	}
	
	@GetMapping("/deleteAccount/{id}")
	public String deleteAccount(@PathVariable(value = "id") String id) {
		this.accountService.deleteAccountById(id);
		return "redirect:/";
	}
}
