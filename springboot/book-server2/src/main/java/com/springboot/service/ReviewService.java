package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dto.ReviewDTO;
import com.springboot.entity.Book;
import com.springboot.entity.Review;
import com.springboot.repository.BookRepository;
import com.springboot.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReviewService {
	
	private final ReviewRepository reviewRepo;
	private final BookRepository bookRepo;
	
	//리뷰 등록
	public Long save(ReviewDTO dto) {
		Book book = bookRepo.findById(dto.getBookId())
		.orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
		
		Review review = Review.toEntity(dto, book);
		return reviewRepo.save(review).getId();
	}

	public Object findAll(Long bookId) {
		Book book = bookRepo.findById(bookId)
				.orElseThrow(() -> new RuntimeException("도서를 찾을 수 없습니다."));
		
		List<Review> list = reviewRepo.findAllByBookOrderByIdDesc(book);
		
		return list.stream()
				.map(ReviewDTO::toDTO)
				.toList();
	}
}
