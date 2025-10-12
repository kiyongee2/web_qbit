package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController3 {
	
	@GetMapping("/auth3")
	public String requestMethod() {
		return "viewPage3";
	}
	
	@GetMapping("/member/tag")
	public String requestMethod2(Model model) {
		return "viewPage3";
	}
	
	
}
