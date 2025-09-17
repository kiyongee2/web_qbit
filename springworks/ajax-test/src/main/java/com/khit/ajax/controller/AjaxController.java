package com.khit.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.ajax.dto.AjaxDTO;

@Controller
public class AjaxController {
	
	@GetMapping("/ex01")
	public String ex01() {
		System.out.println("AjaxController.ex01");
		return "index";
	}
	
	@PostMapping("/ex02")
	public @ResponseBody String ex02() {
		System.out.println("AjaxController.ex02");
		return "index";
	}
	
	@GetMapping("/ex03")
	public @ResponseBody String ex03(@RequestParam("param1") String param1,
									 @RequestParam("param2") String param2) {
		System.out.println("param1 = " + param1 + ", param2 = " + param2);
		return "ex03 메서드 호출 완료!";
	}
	
	@PostMapping("/ex04")
	public @ResponseBody String ex04(@RequestParam("param1") String param1,
									 @RequestParam("param2") String param2) {
		System.out.println("param1 = " + param1 + ", param2 = " + param2);
		return "ex04 메서드 호출 완료!";
	}
	
	@GetMapping("/ex05")
	public @ResponseBody AjaxDTO ex05(@ModelAttribute AjaxDTO ajaxDTO) {
		System.out.println("ajaxDTO = " + ajaxDTO);
		return ajaxDTO;
	}
	
	@PostMapping("/ex06")
	public @ResponseBody AjaxDTO ex06(@ModelAttribute AjaxDTO ajaxDTO) {
		System.out.println("ajaxDTO = " + ajaxDTO);
		return ajaxDTO;
	}
	
	@PostMapping("/ex07")
	public @ResponseBody AjaxDTO ex07(@RequestBody AjaxDTO ajaxDTO) {
		System.out.println("ajaxDTO = " + ajaxDTO);
		return ajaxDTO;
	}
}
