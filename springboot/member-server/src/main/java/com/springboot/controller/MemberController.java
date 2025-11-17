package com.springboot.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entity.Member;
import com.springboot.service.MemberService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", 
	allowCredentials = "true") // React 서버 주소, 쿠키 허용
public class MemberController {

    private final MemberService service;

    //회원 등록
    @PostMapping
    public ResponseEntity<Member> create(@RequestBody Member member) {
        Member saved = service.save(member);
        return ResponseEntity.ok(saved); // 200 OK와 저장된 회원 정보 반환
    }
    
    //회원 목록
    @GetMapping
    public ResponseEntity<List<Member>> getAllMember(){
    	return ResponseEntity.ok(service.findAll()); //모든 회원 정보 반환
    }
    
    //회원 정보(상세 보기)
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id){
    	return ResponseEntity.ok(service.findById(id));
    }
    
    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Member member, HttpSession session) {
    	Member loginMember = service.login(member.getEmail(), member.getPassword());
        session.setAttribute("loginMember", loginMember);
        return ResponseEntity.ok("로그인 성공"); // 200 OK와 성공 메시지 반환
    }
    
    // 로그인 상태 확인
    @GetMapping("/me")
    public ResponseEntity<?> getLoginMember(HttpSession session) {
    	// 세션에서 로그인된 회원 정보 가져오기
        Member loginMember = (Member) session.getAttribute("loginMember");
        if (loginMember != null) {
            return ResponseEntity.ok(loginMember); // 200 OK와 로그인된 회원 정보 반환
        }
        return ResponseEntity.status(401).body("로그인 필요");
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok("로그아웃 성공");
    }
    
    //회원 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
    	service.delete(id);
    	return ResponseEntity.ok("회원 삭제 성공!");
    }

}






















