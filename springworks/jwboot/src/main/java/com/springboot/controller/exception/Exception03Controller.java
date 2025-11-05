package com.springboot.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.exceptions.UserException;

@Controller
public class Exception03Controller {
	
	@GetMapping("/exception03")
	public void method() {
		throw new UserException("UserException 메시지입니다.");
	}
}

