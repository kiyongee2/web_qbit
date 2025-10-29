package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository repository;

	//글쓰기
	public void save(BoardDTO dto) {
		
		Board board = Board.toSaveEntity(dto);
		repository.save(board);
	}

	//글 목록
	public List<Board> findAll() {
		//오름차순 정렬: findAll()
		//내림차순 정렬: 
		return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	//글 상세 보기
	public Board findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> 
					new IllegalArgumentException("해당 글이 존재하지 않습니다. ID=" + id));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void update(BoardDTO dto) {
		//1. 수정할 게시글 가져옴(수정 폼에서 id를 hidden으로 넘겨받음)
		Board board = repository.findById(dto.getId())
				.orElseThrow(() -> 
					new IllegalArgumentException("해당 글이 존재하지 않습니다."));
		
		//2. 제목, 내용 수정
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		repository.save(board);
	}

	@Transactional //트랜잭션(조회수, 상세보기) 완료
	public void updateHits(Long id) {
		repository.updateHits(id);
	}


}
