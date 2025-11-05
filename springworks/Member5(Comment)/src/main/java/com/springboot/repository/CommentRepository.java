package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Board;
import com.springboot.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	//select * from comment_table where board_id = ? order by id desc;
	List<Comment> findAllByBoardOrderByIdDesc(Board board);
	
}
