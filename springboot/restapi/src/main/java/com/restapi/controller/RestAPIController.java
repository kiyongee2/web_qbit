package com.restapi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.dto.UserDTO;


@RestController
public class RestAPIController {
	
	//문자열 전송
	@GetMapping("/space")
	public String restGet() {
		return "<h1>회원 전용 페이지</h1>";
	}

	//회원 조회
	@GetMapping("/space")
	public UserDTO httpGet() {
		UserDTO user = UserDTO.builder()
				.id(1)
				.username("today")
				.password("12345")
				.email("cloud@robot.com")
				.build();
		
		return user;
	}
	
	//등록
	@PostMapping("/space")
	public String httpPost(@RequestBody UserDTO user) {
		return "Post 요청: " + user.toString();
	}
	
	//수정
	@PutMapping("/space")
	public String httpPut(@RequestBody UserDTO user) {
		return "Put 요청 처리" + user.toString();
	}
	
	//삭제
	@DeleteMapping("/space/{id}")
	public String httpDelete(@PathVariable Integer id) {
		return "Delete 요청 처리 " + id; 
	}
}
