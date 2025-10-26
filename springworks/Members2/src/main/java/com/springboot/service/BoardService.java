package com.springboot.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardService {
	private final BoardRepository repository;

	//글쓰기
	public void save(BoardDTO dto) {
		MultipartFile file = dto.getUploadFile();
		String originalFilename = null;
		String storedFilename = null;
		
		if(file != null && !file.isEmpty()) {
			originalFilename = file.getOriginalFilename();
			String uuid = UUID.randomUUID().toString(); 
			storedFilename = uuid + originalFilename;
			
			//폴더가 없으면 자동 생성
			File uploadDir = new File("c:/upload");
			if (!uploadDir.exists()) uploadDir.mkdirs(); 
			
			try {
				file.transferTo(new File(uploadDir, storedFilename));
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("파일 업로드 실패!!");
			}
		}
		
		// Entity 변환 후 DB 저장
		Board board 
			= Board.toSaveEntity(dto, originalFilename, storedFilename);
		repository.save(board);
	}

	//글 목록
	public List<Board> findAll() {
		//오름차순 정렬: findAll()
		//내림차순 정렬: 
		Sort order = Sort.by(Sort.Direction.DESC, "id");
		return repository.findAll(order);
	}
	
	//글 목록(페이지 처리)
	public Page<Board> findAll(Pageable pageable) {
		//pageable = PageRequest.of(0, 10); //오름차순
		int page = pageable.getPageNumber() - 1;
		int pageSize = 10;
		
		log.info("--> pageable.getPageNumber(): " + pageable.getPageNumber());
		//브라우저 확인 - /boards/pages?page=3
		pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "id");
		
		Page<Board> boardList = repository.findAll(pageable);
		//getNumber는 pageNumber 보다 1작음
		log.info("--> boardList.getNumber(): " + boardList.getNumber());
		
		return boardList;
	}
	
	//글 상세 보기
	public Board findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> 
			new IllegalArgumentException("해당 글이 존재하지 않습니다. ID=" + id));
	}
	 
	//글 목록(제목 검색 및 페이지 처리)
	public Page<Board> findByTitleContaining(String keyword, Pageable pageable) {
		int page = pageable.getPageNumber() - 1;
		int pageSize = 10;
		
		pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "id");
		
		Page<Board> boardList =
				repository.findByTitleContaining(keyword, pageable);
		
		return boardList;
	}
	
	//글 목록(제목 및 내용 검색, 페이지 처리)
	public Page<Board> findByContentContaining(String keyword, Pageable pageable) {
		int page = pageable.getPageNumber() - 1;
		int pageSize = 10;
		
		pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "id");
		
		Page<Board> boardList =
				repository.findByContentContaining(keyword, pageable);
		
		return boardList;
	}

	//글 삭제
	public void delete(Long id) {
		repository.deleteById(id);
	}

	//글 수정
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
