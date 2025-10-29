package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/dashboard")
	public String adminDashboard(Model model) {
		model.addAttribute("data", "adminPage.html");
		return "admin/adminPage";
	}
}

