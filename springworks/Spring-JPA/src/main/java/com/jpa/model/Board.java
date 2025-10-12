package com.jpa.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
//@Builder  //junit 테스트에서 사용
@ToString
@Setter
@Getter
@Entity
public class Board {
	@Id //기본키(Primary Key) 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; //자동 순번

	@Column(nullable=false) //필수 입력
	private String title;  //글 제목
	
	@Column(length=20, nullable=false)
	private String writer; //글쓴이
	
	@Column(length=4000, nullable=false)
	private String content;  //글 내용
	
	@CreationTimestamp
	private Timestamp createDate; //작성일
}


