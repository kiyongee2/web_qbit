package com.springboot.controller.exam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Exam03Controller {

	@GetMapping("/exam03")
	public String requestMethod() {
		return "pages/view03";  //view02.html
	}
}

