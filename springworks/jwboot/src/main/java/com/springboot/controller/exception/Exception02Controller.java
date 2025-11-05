package com.springboot.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.exceptions.UserException;

@Controller
public class Exception02Controller {
	
	@GetMapping("/exception02")
	public void method() {
		throw new UserException("페이지를 찾을 수 없습니다.");
	}
	
	@ExceptionHandler(UserException.class)  //로컬 예외 처리(개별적인 예외)
	public String handleException(UserException ex, Model model) {
		model.addAttribute("data1", ex.getMessage());
		model.addAttribute("data2", ex);
		return "exception/viewPage01";
	}
}

