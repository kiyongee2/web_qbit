package com.restapi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entity.User;
import com.restapi.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService service;
	
	//회원 가입
	//@RequestBody - json 데이터 요청
	@PostMapping
	public String saveUser(@RequestBody User user) {
		service.save(user);
		return "회원 가입 성공!";
	}
	
	//회원 목록
	@GetMapping
	public List<User> getAllUsers(){
		List<User> userList = service.findAll();
		return userList;
	}
	
	//회원 상세보기(정보)
	@GetMapping("/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = service.findById(id);
		return user;
	}
	
	//회원 삭제
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Integer id) {
		service.delete(id);
		return "회원 삭제 완료!";
	}
	
	//회원 수정
	@PutMapping("/{id}")
	public String updateUser(@PathVariable Integer id,
			@RequestBody User user) {
		service.update(id, user);
		return "회원 수정 완료!";
	}
}













