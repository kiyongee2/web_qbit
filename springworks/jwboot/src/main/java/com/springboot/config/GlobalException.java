package com.springboot.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler
	private String handleErrorMethod(Exception ex, Model model) {
		model.addAttribute("data1", "GlobalException 메시지입니다.");
		model.addAttribute("data2", ex);
		return "exception/viewPage02";
	}
}
