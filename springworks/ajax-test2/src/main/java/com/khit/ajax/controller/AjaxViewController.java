package com.khit.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax")
@Controller
public class AjaxViewController {
	
	@GetMapping("/ex-01")
	public String ajaxEx01() {
		return "ajax/ex-01";
	}
	
	@GetMapping("/ex-02")
	public String ajaxEx02() {
		return "ajax/ex-02";
	}
	
	@GetMapping("/ex-03")
	public String ajaxEx03() {
		return "ajax/ex-03";
	}
}
