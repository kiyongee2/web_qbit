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

@ToString
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
	
	//다대일 연관 관계 매핑
	//fetch 전략 - 게시글 목록을 볼때마다 member 전체를 매번 로딩하지 않음
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
}
