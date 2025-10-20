package com.springboot.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex02Controller {

	@GetMapping("/boards/{id}")
	public String method1(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("data1", "@PathVariable 예제");
		model.addAttribute("data2", "글번호: " + id);
		return "pages/viewPage02";
	}
}

