package com.springboot.entity;

import java.sql.Timestamp;

import com.springboot.dto.BoardDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;        //글번호
	
	@Column(nullable=false)
	private String title;   //글제목
	
	@Column(length=2000, nullable=false)
	private String content; //글내용
	
	@Column(length=30, nullable=false)
	private String writer;  //글쓴이
	
	@Column(columnDefinition = "Integer default 0")
	private Integer hits;        //조회수
	
	private Timestamp regDate; //작성일
	
	//Entity에 DTO 저장
	public static Board toSaveEntity(BoardDTO dto) {
		Board board = new Board();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setWriter(dto.getWriter());
		board.setHits(0);
		board.setRegDate(new Timestamp(System.currentTimeMillis()));
		
		return board;
	}
}
