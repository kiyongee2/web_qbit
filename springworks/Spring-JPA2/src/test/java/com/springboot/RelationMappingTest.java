package com.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.entity.Board;
import com.springboot.entity.Member;
import com.springboot.repository.BoardRepository;
import com.springboot.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class RelationMappingTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private BoardRepository boardRepo;
	
	/*@Test
	public void insertData() {
		//일반 회원
		Member member1 = new Member();
		member1.setMemberId("member1");
		member1.setPassword("m1111");
		member1.setName("뽀로로");
		member1.setRole("User");
		memberRepo.save(member1);
		
		//관리자
		Member member2 = new Member();
		member2.setMemberId("member2");
		member2.setPassword("m2222");
		member2.setName("아기상어");
		member2.setRole("ADMIN");
		memberRepo.save(member2);
		
		for(int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("뽀로로가 등록한 게시글 " + i);
			board.setContent("뽀로로가 등록한 게시글 내용 " + i);
			board.setMember(member1);
			boardRepo.save(board);
		}
		
		for(int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("아기상어가 등록한 게시글 " + i);
			board.setContent("아기상어가 등록한 게시글 내용 " + i);
			board.setMember(member2);
			boardRepo.save(board);
		}
	}*/
	
	//게시글 조회
	/*@Test
	public void testSelect() {
		Board board = boardRepo.findById(5).get();
		
		log.info("[ " + board.getId() + "번 게시글 정보 ]");
		log.info("제목\t: " + board.getTitle());
		log.info("글쓴이\t: " + board.getMember().getName());
		log.info("내용\t: " + board.getContent());
		log.info("권한\t: " + board.getMember().getRole());
	}*/
	
	//양방향 매핑 테스트 - 한명의 회원이 작성한 모든 게시글 조회
	@Transactional
	@Test
	public void testGetBoardList() {
		//member1이 작성한 게시글 조회
		Member member = memberRepo.findByMemberId("member1");
		
		log.info(member.getName() + "이 작성한 게시글 목록");
		
		List<Board> boardList = member.getBoards();
		for(Board board : boardList)
			log.info(board.toString());
		
	}
}








