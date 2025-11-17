package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapi.entity.User;
import com.restapi.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	//저장소 객체 생성
	private final UserRepository userRepo;

	//회원 가입
	public void save(User user) {
		userRepo.save(user);
	}

	//회원 목록 보기
	public List<User> findAll() {
		return userRepo.findAll();
	}

	//회원 정보(상세 보기)
	public User findById(Integer id) {
		Optional<User> findUser = userRepo.findById(id);
		return findUser.get();
	}

	//회원 삭제
	public void delete(Integer id) {
		userRepo.deleteById(id);
	}
	
	//회원 수정
	public void update(Integer id, User updateUser) {
		User user = findById(id); //수정할 회원 가져옴
		//수정 처리
		user.setUsername(updateUser.getUsername());
		user.setPassword(updateUser.getPassword());
		user.setEmail(updateUser.getEmail());
		userRepo.save(user);
	}
}

