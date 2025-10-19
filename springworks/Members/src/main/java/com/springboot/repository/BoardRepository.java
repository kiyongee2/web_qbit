package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

	//조회수 증가 쿼리 메서드
	@Modifying //삽입, 수정등의 변경이 있을때 사용
	@Query(value="update Board b set b.hits=b.hits+1 where b.id=:id")
	void updateHits(Long id);

	
}
