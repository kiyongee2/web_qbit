package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.dto.CommentDTO;
import com.springboot.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/comment")
@Controller
public class CommentController {
	
	private final CommentService commentService;
	
	//ResponseEntity - Body와 Header를 다룰수 있는 객체
	@PostMapping("/save")
	public ResponseEntity save(@ModelAttribute CommentDTO commentDTO) {
		log.info("commentDTO: " + commentDTO);
		Long saveResult = commentService.save(commentDTO);
		if(saveResult != null) {
			//등록 성공하면 댓글 목록 가져와서 리턴
			List<CommentDTO> commentDTOList = 
					commentService.findAll(commentDTO.getBoardId());
			return new ResponseEntity<>(commentDTOList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("해당 게시글이 존재하지 않습니다.", 
					HttpStatus.NOT_FOUND);
		}
		
	}
}


