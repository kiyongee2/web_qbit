package com.springboot.controller.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exam02")
@RestController
public class Exam02Controller {

	@RequestMapping
	public String requestMethod() {
		return "<h2>@RestController 예제 입니다.</h2>";  //문자열 출력
	}
}

