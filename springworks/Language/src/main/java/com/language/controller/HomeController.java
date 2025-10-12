package com.language.controller;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
    public String home(Model model) {
		// 로케일 정보를 로그로 출력해서 확인
        System.out.println("Current locale: " + LocaleContextHolder.getLocale());
        return "index";
    }
}
