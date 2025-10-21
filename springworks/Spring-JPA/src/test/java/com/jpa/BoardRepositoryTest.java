package com.jpa;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.model.Board;
import com.jpa.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@SpringBootTest
public class BoardRepositoryTest {
	
	@Autowired
	private BoardRepository repository;
	
	//게시글 생성
	/*@Test
	public void insertBoard() {
		Board board = new Board();
		
		board.setTitle("가입 인사");
		board.setWriter("박신입");
		board.setContent("안녕하세요~ 가입 인사 드려요");
		board.setCreateDate(new Timestamp(System.currentTimeMillis()));
		
		repository.save(board);
		log.info("board:" + board);
		
		Board board = Board.builder()
				.title("안녕하세요")
				.writer("이신입")
				.content("잘 부탁드립니다..")
				.createDate(new Timestamp(System.currentTimeMillis()))
				.build();
		
		repository.save(board);
		
		log.info("board:" + board);
	}*/
	
	//게시글 목록
	@Test
	public void getBoardList() {
		List<Board> boardList = repository.findAll();
		
		//기본 생성자 오류 해결 - Board에 NoArgsConstructor
		/*for(Board board : boardList)
			log.info(board.toString());*/
		boardList.forEach(board -> log.info(" " + board));
	}
	
	//게시글 삭제
	/*@Test
	public void deleteBoard() {
		log.info("1번째 게시글 삭제");
		repository.deleteById(1);
	}*/
	
	//게시글 수정
	/*@Test
	public void updateBoard() {
		log.info("** 2번 게시글 조회 **");
		Board board = repository.findById(2).get();
		
		log.info("** 2번 게시글 제목 수정 **");
		board.setTitle("제목을 수정합니다.");
		
		//수정후 저장
		repository.save(board);
	}*/
	
	//게시글 상세
	/*@Test
	public void getBoard() {
		//2번째 게시글 가져오기
		Board board = repository.findById(2).get();
		log.info(board.toString());
	}*/
}




