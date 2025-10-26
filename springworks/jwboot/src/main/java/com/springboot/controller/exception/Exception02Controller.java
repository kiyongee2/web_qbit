package com.springboot.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.config.UserException;

@Controller
public class Exception02Controller {
	
	@GetMapping("/exception02")
	public void method() throws Exception {
		throw new Exception(new UserException("페이지를 찾을 수 없습니다."));
	}

}
