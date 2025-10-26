package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.dto.MemberDTO;
import com.springboot.entity.Member;
import com.springboot.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {
	private final MemberService service;
	
	@GetMapping("/join") //회원 가입 페이지
	public String joinForm() {
		return "member/join";
	}
	
	@PostMapping("/join")  //회원 가입 처리
	public String join(@ModelAttribute MemberDTO dto,
			RedirectAttributes ra) {
		//리다이렉트시에 메시지 전달
		try {
			service.save(dto);
			ra.addFlashAttribute("msg", "회원가입 성공!");
			return "redirect:/members/login";
		}catch(Exception e) {
			ra.addFlashAttribute("error", e.getMessage());
			return "redirect:/members/join";
		}
	}
	
	@GetMapping  //회원 목록
	public String getMemberList(Model model) {
		List<Member> memberList = service.findAll();
		model.addAttribute("memberList", memberList);
		return "member/list";
	}
	
	@GetMapping("/{id}") //회원 정보(상세)
	public String getMember(@PathVariable Long id, 
							Model model) {
		Member member = service.findById(id);
		model.addAttribute("member", member);
		return "member/info";
	}

	 //회원 삭제
	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/members";
	}
	
	//로그인 페이지
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
	}
}





