package com.khit.jpa.repository;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.khit.jpa.model.Board;

import lombok.Builder;

@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository repository;
	
	//게시글 생성
	@Test
	public void insertBoard() {
		/*Board board = new Board();
		board.setTitle("가입 인사");
		board.setWriter("박신입");
		board.setContent("안녕하세요~ 방가방가");
		board.setCreateDate(new Timestamp(System.currentTimeMillis()));*/
		
		Board board = Board.builder()
				.title("안녕하세요")
				.writer("이신입")
				.content("잘 부탁드립니다..")
				.createDate(new Timestamp(System.currentTimeMillis()))
				.build();
		
		repository.save(board);
	}
}
