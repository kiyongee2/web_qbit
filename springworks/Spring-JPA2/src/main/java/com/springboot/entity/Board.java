package com.springboot.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "member") //순환 참조 오류 방지
@Setter
@Getter
@Entity
public class Board {
	@Id  //PRIMARY KEY(기본키) - 없으면 에러발생
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 순번
	private Integer id;     //번호
	
	@Column(nullable = false)
	private String title;   //글 제목
	
	@Column(length = 2000, nullable = false)
	private String content; //글 내용
	
	@CreationTimestamp //시간 자동 저장
	private Timestamp createdDate; //작성일
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn()  //조인 - 참조 관계
	private Member member;
}
