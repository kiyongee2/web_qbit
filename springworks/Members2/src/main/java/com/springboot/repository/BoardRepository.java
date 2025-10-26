package com.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	//조회수 증가 쿼리 메서드
	@Modifying //삽입, 수정등의 변경이 있을때 사용
	@Query(value="update Board b set b.hits=b.hits+1 where b.id=:id")
	void updateHits(Long id);
	
	//제목 검색어가 포함된 게시글 목록을 페이치 처리하여 조회 - Page<T> 사용
	Page<Board> findByTitleContaining(String keyword, Pageable pageable);

	//제목 및 내용 검색어가 포함된 게시글 목록을 페이치 처리하여 조회 - Page<T> 사용
	Page<Board> findByContentContaining(String keyword, Pageable pageable);
}


