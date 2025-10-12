package com.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {
	
	@GetMapping("/languages")
	public String requestMethod() {
		return "languagePage";
	}
}
