package com.springboot.dto;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BoardDTO {
	private Long id;  //글번호
	
	@NotEmpty(message="제목은 필수 항목입니다.")
	private String title;   //글제목
	
	@NotEmpty(message="내용은 필수 항목입니다.")
	private String content; //글내용
	
	private String writer;  //글쓴이
	
	private Integer hits;   //조회수
	
	private MultipartFile uploadFile; //업로드 파일
	
	private Timestamp regDate; //작성일
}

