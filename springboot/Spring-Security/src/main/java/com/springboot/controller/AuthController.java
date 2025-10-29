package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	@GetMapping("/auth")
	public String method1() {
		return "authentication/viewPage";
	}
	
	@GetMapping("/home/main")
	public String method2(Model model) {
		model.addAttribute("data", "homePage.html");
		return "authentication/homePage";
	}
	
	@GetMapping("/user/main")
	public String method3(Model model) {
		model.addAttribute("data", "userPage.html");
		return "authentication/userPage";
	}
	
	@GetMapping("/admin/main")
	public String method4(Model model) {
		model.addAttribute("data", "adminPage.html");
		return "authentication/adminPage";
	}
	
	@GetMapping("/login")
	public String login() {
		return "member/login";
	}
}
