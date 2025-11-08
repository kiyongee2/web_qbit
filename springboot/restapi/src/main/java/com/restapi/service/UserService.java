package com.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapi.UserRepository;
import com.restapi.entity.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findById(Integer id) {
		Optional<User> findUser = userRepo.findById(id);
		return findUser.get();
	}

	public void update(User user) {
		userRepo.save(user);
	}

	public void delete(Integer id) {
		userRepo.deleteById(id);
	}
}
