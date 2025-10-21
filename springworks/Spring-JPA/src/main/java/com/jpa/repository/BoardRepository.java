package com.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Board;

//JpaRepository를 상속받은 BoardRepository 인터페이스
public interface BoardRepository extends JpaRepository<Board, Integer>{
	//쿼리 메서드 - 글 제목 검색
	List<Board> findByTitle(String searchKeyword);
	
	//특정 단어가 포함된 글 내용 검색
	List<Board> findByContentContaining(String searchKeyword);
	
	//글 제목 또는 내용에 특정 단어가 포함된 목록 검색
	List<Board> findByTitleContainingOrContentContaining(String title,
						String content);
	
	//글 제목에 특정 단어가 포함된 글 목록을 내림차순으로 검색
	List<Board> findByTitleContainingOrderByIdDesc(String searchKeyword);
	
	//제목 검색어가 포함된 게시글 목록을 페이치 처리하여 조회 - List<E> 사용
	//List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	//제목 검색어가 포함된 게시글 목록을 페이치 처리하여 조회 - Page<T> 사용
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
}

