package com.springboot.entity;

import java.sql.Timestamp;
import java.util.Optional;

import org.hibernate.annotations.CreationTimestamp;

import com.springboot.dto.CommentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "t_comment")
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=20, nullable=false)
	private String commentWriter;
	
	@Column
	private String commentContent;
	
	@CreationTimestamp
	private Timestamp commentDate;
	
	//Member 참조 관계(연관 매핑) : 다대일
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Member member;
	
	//Board 참조 관계(연관 매핑) : 다대일
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Board board;

	public static Comment toSaveEntity(CommentDTO commentDTO, 
			Board board) {
		Comment comment = new Comment();
		comment.setCommentWriter(commentDTO.getCommentWriter());
		comment.setCommentContent(commentDTO.getCommentContent());
	    comment.setBoard(board);
		return comment;

	}
}


