package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.MemberDTO;
import com.springboot.repository.MemberRepository;

import lombok.AllArgsConstructor;

@RequestMapping("/members")
//@AllArgsConstructor //생성자 주입 - 객체 생성
@Controller
public class MemberController {
	
	@Autowired
	private MemberRepository repository;
	
	//회원 등록 화면
	@GetMapping("/add")
	public String addForm() {
		return "member/add";  //add.html
	}
	
	//회원 등록 처리
	@PostMapping("/add")
	public String add(@ModelAttribute MemberDTO dto) {
		//System.out.println("MemberDTO: " + dto);
		repository.save(dto);
		return "redirect:/members";
	}
	
	//회원 목록 보기
	@GetMapping
	public String list(Model model) {
		List<MemberDTO> members = repository.findAll();
		model.addAttribute("members", members);
		return "member/members";
	}
}












