package com.springboot.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.config.UserException;

@Controller
public class Exception04Controller {
	
	@GetMapping("/exception04")
	public void method() {
		throw new UserException("페이지를 찾을 수 없습니다.");
	}
}
