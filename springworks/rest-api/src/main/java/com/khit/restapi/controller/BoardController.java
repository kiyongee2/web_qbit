package com.khit.restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khit.restapi.entity.BoardVO;
import com.khit.restapi.service.BoardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BoardController {
	
	private BoardService service; 
	
	@GetMapping("/greeting")
	public String sayHello(String name) {
		return "Hello~ " + name;
	}
	
	@GetMapping("/board/detail")
	public BoardVO getBoard() {
		BoardVO board = service.getBoard();
		return board;
	}
	
	@GetMapping("/board/list")
	public List<BoardVO> getBoardList(){
		List<BoardVO> boardList = service.getBoardList();
		return boardList;
	}
	
	
}
