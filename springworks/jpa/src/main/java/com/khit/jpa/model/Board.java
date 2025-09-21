package com.khit.jpa.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@ToString
@Setter
@Getter
public class Board {
	@Id //기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동 순번
	private int id;

	private String title;
	
	@Column(length=20, nullable=false)
	private String writer;
	
	private String content;
	
	@CreationTimestamp
	private Timestamp createDate;
}
