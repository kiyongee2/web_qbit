package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.dto.CommentDTO;
import com.springboot.entity.Board;
import com.springboot.entity.Comment;
import com.springboot.repository.BoardRepository;
import com.springboot.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
	private final CommentRepository commentRepo;
	private final BoardRepository boardRepo;

	//댓글 등록
	public Long save(CommentDTO commentDTO) {
		//부모 엔티티 조회
		Optional<Board> optionalBoard =
				boardRepo.findById(commentDTO.getBoardId());
		if(optionalBoard.isPresent()) {
			Board board = optionalBoard.get();
			Comment comment = Comment.toSaveEntity(commentDTO, board);
			return commentRepo.save(comment).getId();
		}else {
			return null;
		}
	}

	//댓글 목록
	public List<CommentDTO> findAll(Long boardId) {
		//해당 ID로 검색한 게시글 가져오기
		Board board = boardRepo.findById(boardId).get();
		
		//댓글을 가져와서 댓글번호로 내림차순 정렬하기
		List<Comment> commentList = 
				commentRepo.findAllByBoardOrderByIdDesc(board);
		
		//entity를 dto로 변환
		List<CommentDTO> commentDTOList = new ArrayList<>();
		for(Comment comment : commentList) {
			CommentDTO commentDTO = CommentDTO.toCommentDTO(comment, boardId);
			commentDTOList.add(commentDTO);
		}
		
		return commentDTOList;
	}
}



