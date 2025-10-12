package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Board;

//JpaRepository를 상속받은 BoardRepository 인터페이스
public interface BoardRepository extends JpaRepository<Board, Integer>{
	
}
