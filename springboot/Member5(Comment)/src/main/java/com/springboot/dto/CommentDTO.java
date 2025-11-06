package com.springboot.dto;

import java.sql.Timestamp;

import com.springboot.entity.Comment;

import lombok.Data;

@Data
public class CommentDTO {
	private Long id;  //댓글 번호
	private String commentWriter;  //작성자
	private String commentContent; //내용
	private Long boardId; //게시글 번호
	private Timestamp commentDate; //작성일
	
	//entity를 dto로 변환
	public static CommentDTO toCommentDTO(Comment comment,
			Long boardId) {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setId(comment.getId());  
		commentDTO.setCommentWriter(comment.getCommentWriter()); 
		commentDTO.setCommentContent(comment.getCommentContent()); 
		commentDTO.setCommentDate(comment.getCommentDate()); 
		//commentDTO.setBoardId(comment.getBoard().getId());
		commentDTO.setBoardId(boardId); 
		
		return commentDTO;
	}
}
