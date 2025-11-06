package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
		model.addAttribute("pageTitle", "관리자 대시보드");
        model.addAttribute("totalMembers", 152);
        model.addAttribute("totalBoards", 47);
        model.addAttribute("todayVisitors", 29);
        return "admin/dashboard";
    }
}
