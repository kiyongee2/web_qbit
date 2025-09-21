package com.khit.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.view.model.Member;
import com.khit.view.repository.MemberRepository;

import lombok.AllArgsConstructor;

@RequestMapping("/members")
@AllArgsConstructor
@Controller
public class MemberController {
	
	private MemberRepository repository;
	
	//회원 목록 보기
	@GetMapping
	public String list(Model model) {
		model.addAttribute("members", repository.findAll());
		return "member/members";
	}
	
	//회원 등록 화면
	@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/add";
	}
	
	//회원 등록 처리
	@PostMapping("/add")
	public String add(Member member) {
		repository.save(member);
		return "redirect:/members";
	}
	
}












