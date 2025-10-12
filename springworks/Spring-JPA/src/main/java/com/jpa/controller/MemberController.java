package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpa.model.Member;
import com.jpa.repository.MemberRepository;

@RequestMapping("/members")
@Controller
public class MemberController {

	@Autowired
	MemberRepository repository;
	
	@GetMapping //모든 레코드 조회
	public String viewHomePage(Model model) {
		Iterable<Member> memberList = repository.findAll();
		model.addAttribute("memberList", memberList);
		return "viewPage";
	}
	
	@GetMapping("/new")  //삽입 뷰 페이지
	public String newMethod(Model model) {
		//Member member = new Member();
		//model.addAttribute("member", member);
		return "viewPage_new";
	}
	
	@PostMapping("/insert")  //삽입 처리
	public String insertMethod(Member member) {
		repository.save(member);
		return "redirect:/members";
	}
}










