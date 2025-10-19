package com.springboot.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boards")
@Controller
public class BoardController {
	
	private final BoardService service;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm(BoardDTO boardDTO) {
		log.info("Has errors...");
		return "board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@Valid BoardDTO dto,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "board/write";
		}
		service.save(dto);
		return "redirect:/boards";
	}
	
	//글 목록
	@GetMapping
	public String getBordList(Model model){
		List<Board> boardList = service.findAll();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
	
	//글목록(페이지 처리)
	//boards/pages?page=0
	@GetMapping("/pages")
	public String getBoardPage(Model model, 
			@PageableDefault(page=1) Pageable pageable) {
		
		Page<Board> boardList = service.findAll(pageable);
		
		//하단의 페이지 블럭
		int blockLimit = 10;
		
		//시작 페이지 - 1, 2, 3...
		//시작 번호 -   1, 11, 21...
		//예) 번호 - 13,  13/10-1.3 -> 2(올림)-1 * 10 + 1 => 11
		int startPage 
			= ((int)Math.ceil((double)pageable.getPageNumber() / blockLimit)-1) * blockLimit+1;
		//페이지의 행번호(끝) 10, 20, 30...
		//int endPage = startPage + blockLimit - 1;
		int endPage = (startPage + blockLimit - 1) > boardList.getTotalPages() ?
				boardList.getTotalPages() : (startPage + blockLimit - 1);
		
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/pages";
	}
	
	//글 상세보기
	@GetMapping("/{id}")
	public String getBoard(@PathVariable Long id,
			Model model) {
		try {
			//조회수 증가
			service.updateHits(id);
			
			//글 상세 보기
			Board board = service.findById(id);
			model.addAttribute("board", board);
			return "board/detail";
		}catch(Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/404.html";
		}
	}
	
	//글 삭제
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/boards";
	}
	
	//글 수정 페이지
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable Long id,
			Model model) {
		Board board = service.findById(id);
		model.addAttribute("board", board);
		return "board/update";
	}
	
	//글 수정 처리
	@PostMapping("/update")
	public String update(@ModelAttribute BoardDTO dto) {
		service.update(dto);
		return "redirect:/boards/" + dto.getId();
	}
	
}




