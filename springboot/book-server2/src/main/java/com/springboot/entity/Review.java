package com.springboot.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.springboot.dto.ReviewDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Review extends BaseEntity{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=50)
	private String writer;
	
	@Column(nullable=false)
	private String content;
	
	//한권의 책에 여러개의 리뷰가 달림
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;
	
	//DTO를 Entity로 변환
	public static Review toEntity(ReviewDTO dto, Book book) {
		Review review = new Review();
		review.setWriter(dto.getWriter());
		review.setContent(dto.getContent());
		review.setBook(book);
		return review;
	}

}
