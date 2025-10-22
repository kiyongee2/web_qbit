package com.springboot.controller.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.Product;

import jakarta.validation.Valid;

@RequestMapping("/valid01")
@Controller
public class ValidController {
	
	@GetMapping
	public String showForm(@ModelAttribute Product product) {
		return "validation/viewPage01";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute Product product, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "validation/viewPage01";
		
		return "validation/viewPage01_result";
	}
}
