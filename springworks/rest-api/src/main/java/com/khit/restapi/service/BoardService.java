package com.khit.restapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.khit.restapi.entity.BoardVO;

@Controller
public class BoardService {
	
	public BoardVO getBoard() {
		BoardVO board = new BoardVO();
		board.setId(1);
		board.setTitle("채식주의자");
		board.setWriter("한강");
		board.setContent("채식주의자 내용...");
		board.setCreateDate(new Date());
		return board;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			BoardVO board = new BoardVO();
			board.setId(i);
			board.setTitle("제목" + i);
			board.setWriter("저자" + i);
			board.setContent(i + "번째 내용입니다...");
			board.setCreateDate(new Date());
			
			list.add(board);
		}
		return list;
	}
}
