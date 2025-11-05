package com.springboot;

import java.util.List;
import java.util.Optional;

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
	
	//특정 게시글을 작성한 회원 조회
	//트랜잭션이 닫힌 후 Lazy 로딩이 되어 오류 발생함 - @Transactional 사용
	@Transactional 
	@Test
	public void testSelect() {
		Optional<Board> optionalBoard = boardRepo.findById(5);
		log.info("[" + optionalBoard.get().getId() + "번 게시글 정보]");
		
		if(optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			log.info("제목: " + board.getTitle());
			log.info("내용: " + board.getContent());
			log.info("글쓴이: " + board.getMember().getName());
		}else {
			log.info("해당 게시글을 찾을 수 없습니다.");
		}
	}
	
	//한명의 회원이 작성한 모든 게시글 조회
	@Transactional
	@Test
	public void testGetBoardList() {
		//member1 회원 가져오기
		Member member = memberRepo.findByMemberId("member1").get();
		
		log.info(member.getName() + "가(이) 작성한 게시글 목록");
		
		//member1이 작성한 모든 게시글 가져오기
		List<Board> boardList = member.getBoards();
		
		for(Board board : boardList)
			log.info(board.toString());
	}
}










