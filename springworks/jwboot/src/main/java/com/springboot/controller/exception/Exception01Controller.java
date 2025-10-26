package com.springboot.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Exception01Controller {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)	
	@GetMapping("/exception01")
	public void method1() {
		log.info(new IllegalArgumentException("찾는 페이지가 없습니다.").getMessage());
	}
}
