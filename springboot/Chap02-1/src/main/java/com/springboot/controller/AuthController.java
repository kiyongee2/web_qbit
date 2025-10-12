package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	@GetMapping("/auth")
	public String requestMethod() {
		return "viewPage";
	}
	
	@GetMapping("/home/main")
	public String requestMethod2(Model model) {
		model.addAttribute("data", "homePage.html");
		return "homePage";
	}
	
	@GetMapping("/member/main")
	public String requestMethod3(Model model) {
		model.addAttribute("data", "memberPage.html");
		return "memberPage";
	}
	
	@GetMapping("/admin/main")
	public String requestMethod4(Model model) {
		model.addAttribute("data", "adminPage.html");
		return "adminPage";
	}
	
	@GetMapping("/login")
	public String requestLogin() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String requestLogout() {
		return "redirect:/auth";
	}
}
