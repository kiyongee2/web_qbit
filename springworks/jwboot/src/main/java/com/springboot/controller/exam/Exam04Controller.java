package com.springboot.controller.exam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exam04Controller {

	@GetMapping("/exam04")
	public String requestMethod(Model model) {
		model.addAttribute("data1", "Model 예제");
		model.addAttribute("data2", "웹 요청 URL은 /exam04 입니다.");
		return "pages/view04";  //view04.html
	}
}

