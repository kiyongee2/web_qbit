package com.khit.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khit.ajax.dto.AjaxDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController {

	@GetMapping("/ex01")
	public @ResponseBody String ex01(
			    @RequestParam("param1") String param1,
			    @RequestParam("param2") String param2) {
		log.info("param1 = " + param1 + ", param2 = " + param2);
		return "데이터 전달 성공!";
	}
	
	@PostMapping("/ex02")
	public @ResponseBody AjaxDTO ex02(@ModelAttribute AjaxDTO ajaxDTO) {
		log.info("ajaxDTO = " + ajaxDTO);
		return ajaxDTO;
	}
	
	//@RequestBody - json 데이터 요청
	@PostMapping("/ex03")
	public @ResponseBody AjaxDTO ex03(@RequestBody AjaxDTO ajaxDTO) {
		log.info("ajaxDTO = " + ajaxDTO);
		return ajaxDTO;
	}
}
