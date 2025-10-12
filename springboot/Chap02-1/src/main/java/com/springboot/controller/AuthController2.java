package com.springboot.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController2 {
	
	@GetMapping("/auth2")
	public String requestMethod() {
		return "redirect:/member/user";
	}
	
	@GetMapping("/member/user")
	public String requestMethod2(Authentication authentication, Model model) {
		UserDetails user = (UserDetails) authentication.getPrincipal();
		String username = user.getUsername();
		String password = user.getPassword();
		
		model.addAttribute("data1", "/member/user");
		model.addAttribute("data2", username);
		model.addAttribute("data3", password);
		
		//사용자 역할 권한 가져오기
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
		for(GrantedAuthority item : authorities) {
			model.addAttribute("data4", item + " ");
		}
		
		return "viewPage2";
	}
	
	
}
