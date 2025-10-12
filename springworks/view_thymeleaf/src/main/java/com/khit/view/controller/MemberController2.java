package com.khit.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khit.view.model.Member;
import com.khit.view.repository.MemberRepository;

import lombok.AllArgsConstructor;

@RequestMapping("/members")
@AllArgsConstructor
@Controller
public class MemberController2 {
	
	private MemberRepository repository;
	
	//회원 목록 보기
	@GetMapping
	public String list(Model model) {
		model.addAttribute("members", repository.findAll());
		return "member/members";
	}
	
	//회원 등록 화면
	@GetMapping("/add")
	public String addForm() {
		return "member/add";
	}
	
	/*@GetMapping("/add")
	public String addForm(Model model) {
		model.addAttribute("member", new Member());
		return "member/add";
	}*/
	
	//회원 등록 처리
	@PostMapping("/add")
	public String add(Member member) {
		repository.save(member);
		return "redirect:/members";
	}
	
	// 회원 삭제
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		repository.delete(id);
		return "redirect:/members";
	}
	
}












