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

import com.Group3.ManagementCinema.entity.Rate;
import com.Group3.ManagementCinema.entity.RateId;
import com.Group3.ManagementCinema.service.RateService;

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
	public String searchRate(@RequestParam("id") RateId id, Model model) {
		Rate rate = rateService.getRateById(id);
		model.addAttribute("rate", rate);
		return "";
	}
	
	@PostMapping("/saveRate")
    public String saveRate(@ModelAttribute("rate") Rate rate, RedirectAttributes redirectAttributes) {
		rateService.saveRate( 
						rate.getTaiKhoan().getEmail(),
						rate.getPhim().getIdPhim(),
						rate.getNoiDung());
        return "";
    }
	
	@PostMapping("/updateRate")
	public String updateRate(@ModelAttribute("movieSchedule") Rate rate, Model model) {
		rateService.saveRate(rate);
		return "";
	}		
	
	@GetMapping("/showFormForUpdateRate/{id}")
	public String showFormForUpdateRate(@PathVariable(value = "id") RateId id, Model model) {
		Rate rate = rateService.getRateById(id);
		model.addAttribute("rate", rate);
		return "";
	}
	
	@GetMapping("/deleteRate/{id}")
	public String deleteRate(@PathVariable(value = "id") RateId id) {
		this.rateService.deleteRateById(id);
		return "";
	}
}
