package com.jpa;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpa.model.Board;
import com.jpa.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j  //로그 출력
@SpringBootTest
public class QueryMethodTest {

	@Autowired
	private BoardRepository repository;
	
	/*@BeforeEach
	public void dataPrepare() {
		for(int i=1; i<=200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목 " + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용 " + i);
			board.setCreateDate(new Timestamp(System.currentTimeMillis()));
			
			repository.save(board);
		}
	}*/
	
	@Test
	public void testFindByTitle() {
		List<Board> boardList = repository.findByTitle("테스트 제목 10");
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}
	
	/*@Test
	public void testFindByContentContaining() {
		List<Board> boardList = repository.findByContentContaining("17");
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByTitleContainingOrContentContaining() {
		List<Board> boardList = 
				repository.findByTitleContainingOrContentContaining("17", "18");
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	/*@Test
	public void testFindByTitleContainingOrderByIdDesc() {
		List<Board> boardList = 
				repository.findByTitleContainingOrderByIdDesc("18");
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	//페이지 처리 및 정렬 - List<Board> 사용
	/*@Test
	public void testFindByTitleContaining() {
		//0->첫 페이지 번호(pageNumber), 1 -> 둘째 페이지 번호
		//10->데이터 개수(pageSize)
		//Default - 오름차순 정렬
		//Pageable paging = PageRequest.of(1, 10); 
		
		//내림차순 정렬
		Pageable paging = PageRequest.of(1, 10, Sort.Direction.DESC, "id"); 
		
		List<Board> boardList = 
				repository.findByTitleContaining("제목", paging);
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}*/
	
	//페이지 처리 및 정렬 - Page<Board> 사용
	@Test
	public void testFindByTitleContaining() {
		Pageable paging = PageRequest.of(1, 10); 
		
		//내림차순 정렬
		//Pageable paging = PageRequest.of(1, 10, Sort.Direction.DESC, "id"); 
		
		//페이지 정보 객체 생성
		Page<Board> pageInfo = 
				repository.findByTitleContaining("제목", paging);
		
		log.info("PAGE SIZE: " + pageInfo.getSize());  //10(페이지당 데이터수)
		log.info("TOTAL PAGES: " + pageInfo.getTotalPages()); //전체 페이지수
		log.info("TOTAL COUNT: " + pageInfo.getTotalElements()); //전체 데이터수
		
		//글 목록 반환 객체 생성
		List<Board> boardList = pageInfo.getContent();
		
		log.info("검색 결과");
		for(Board board : boardList) {
			log.info("--->" + board.toString());
		}
	}
}











