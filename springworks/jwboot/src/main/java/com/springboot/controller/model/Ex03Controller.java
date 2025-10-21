package com.springboot.controller.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Ex03Controller {
	
	@GetMapping("/ex03")
	public @ResponseBody User requestMethod() {
		User user = User.builder()
				.id("apple")
				.pw("12345")
				.build();	
		return user;
	}

	// 입력 폼 페이지
    @GetMapping("/userForm")
    public String formPage() {
        return "pages/userForm";
    }

    // 결과 처리 (POST)
    @PostMapping("/login")
    public String resultPage(@ModelAttribute User user, Model model) {
    	System.out.println("User: " + user);
        model.addAttribute("data1", "@ModelAttribute 예제 - 결과 페이지");
        model.addAttribute("data2",
                "id: " + user.getId() + "<br>pw: " + user.getPw());

        return "pages/viewPage03";
    }
}

