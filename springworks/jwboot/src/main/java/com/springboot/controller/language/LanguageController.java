package com.springboot.controller.language;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanguageController {

	@GetMapping("/lang01")
	public String method() {
		
		return "language/viewPage01";
	}
}
