package com.khit.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		//모델(message)에 문자열을 담아 보내기
		model.addAttribute("message", "Hello~ Thymeleaf!");
		return "home"; //파일: home.html
	}
	
	@GetMapping("/time")
	public String time() {
		return "/pages/time";  //파일경로: /pages/home.html
	}
}



