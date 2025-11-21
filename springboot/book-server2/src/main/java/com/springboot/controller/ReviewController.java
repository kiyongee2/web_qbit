package com.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.ReviewDTO;
import com.springboot.entity.Book;
import com.springboot.service.ReviewService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
@RestController
public class ReviewController {
	
	private final ReviewService service;
	
	//리뷰 등록
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ReviewDTO dto){
		Long id = service.save(dto);
		return ResponseEntity.ok(id);
	}
	
	//리뷰 목록
	@GetMapping("/{bookId}")
	public ResponseEntity<?> list(@PathVariable Long bookId){
		return ResponseEntity.ok(service.findAll(bookId));
	}
}





