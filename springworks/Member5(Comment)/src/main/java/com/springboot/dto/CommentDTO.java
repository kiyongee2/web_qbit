package com.springboot.dto;

import java.sql.Timestamp;

import com.springboot.entity.Comment;

import lombok.Data;

@Data
public class CommentDTO {
	private Long id;
	private String commentWriter;
	private String commentContent;
	private Long boardId;
	private Timestamp commentDate;
	
	public static CommentDTO toCommentDTO(Comment comment,
			Long boardId) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());
		commentDTO.setCommentWriter(comment.getCommentWriter());
		commentDTO.setCommentContent(comment.getCommentContent());
		//commentDTO.setBoardId(comment.getBoard().getId());
		commentDTO.setBoardId(boardId);
		
		return commentDTO;
	}
}
