package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.entity.Member;
import com.springboot.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/admin")
@RequiredArgsConstructor
@Controller
public class AdminController {
	
	private final MemberService service;
	
	@GetMapping("/list")  //회원 목록
	public String getMemberList(Model model) {
		List<Member> memberList = service.findAll();
		model.addAttribute("memberList", memberList);
		return "admin/memberList";
	}
	
}
