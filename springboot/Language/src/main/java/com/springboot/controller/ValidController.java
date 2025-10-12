package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.Product;

import jakarta.validation.Valid;

@Controller
public class ValidController {
	
	@GetMapping("/valid")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "viewPage";
	}
	
	@PostMapping("/valid")
	public String submit(@Valid @ModelAttribute Product product,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "viewPage";
		}
		return "viewPage_result";
	}
	
}
