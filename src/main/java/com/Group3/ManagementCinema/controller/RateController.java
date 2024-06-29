package com.Group3.ManagementCinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Group3.ManagementCinema.entity.Account;
import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.service.RateService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class RateController {
	@Autowired
	private RateService rateService;
	
	@GetMapping("/rates")
	public String viewRate(Model model) {
		model.addAttribute("listRates", rateService.getAllRates());
		return "";
	}
	
	@GetMapping("/showNewRateForm")
    public String showNewRateForm(Model model) {
		Rate rate = new Rate();
        model.addAttribute("rate", rate);
        return "";
    } 
	
	@GetMapping("/searchRateById")
	public String searchRateById(@RequestParam("id") Long id, Model model) {
		Rate rate = rateService.getRateById(id);
		model.addAttribute("rate", rate);
		return "";
	}
	
	@PostMapping("/saveRate")
    public String saveRate(@ModelAttribute("rate") Rate rate, RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
	    Account account = (Account) session.getAttribute("account");
	    if (account == null) {
	        // Nếu không có account trong session, chuyển hướng đến trang đăng nhập
	        return "redirect:/login";
	    }
		rateService.saveRate( 
						rate.getId(),
						rate.getTaiKhoan().getEmail(),
						rate.getPhim().getIdPhim(),
						rate.getDiem(),
						rate.getBinhLuan());
        return "redirect:/film/" + rate.getPhim().getIdPhim();
    }
	
	@PostMapping("/updateRate")
	public String updateRate(@ModelAttribute("movieSchedule") Rate rate, Model model) {
		rateService.saveRate(rate);
		return "";
	}		
	
	@GetMapping("/showFormForUpdateRate/{id}")
	public String showFormForUpdateRate(@PathVariable(value = "id") Long id, Model model) {
		Rate rate = rateService.getRateById(id);
		model.addAttribute("rate", rate);
		return "";
	}
	
	@GetMapping("/deleteRate/{id}")
	public String deleteRate(@PathVariable(value = "id") Long id) {
		this.rateService.deleteRateById(id);
		return "";
	}
}
