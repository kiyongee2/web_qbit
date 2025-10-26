package com.springboot.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
//@RestController
@Controller
public class UserExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	public String GlovalExceptionHandle(Exception e, 
			Model model) {
		//return "<h2>" + e.getMessage() + "</h2>"; //RestController 경우
		model.addAttribute("errorMsg", e.getMessage());
		return "error/errorPage";
	}
}
