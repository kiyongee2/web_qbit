package com.springboot.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.springboot.dto.BoardDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "t_board")
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
	
	private String originalFilename; //실제 파일명
	
	private String storedFilename;   //서버에 저장된 파일명
	
	@CreationTimestamp
	private Timestamp regDate; //작성일
	
	//Member와 참조 연관매핑 - 다대일
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Member member;
	
	//Comment와 참조 연관 매핑
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	@OrderBy("id desc")
	private List<Comment> commentList = new ArrayList<>();
	
	
	//Entity에 DTO 저장 메서드
	public static Board toSaveEntity(BoardDTO dto,
			String originalFilename, String storedFilename) {
		Board board = new Board();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setWriter(dto.getWriter());
		board.setHits(0);
		board.setOriginalFilename(originalFilename);
		board.setStoredFilename(storedFilename);
		
		return board;
	}
}
