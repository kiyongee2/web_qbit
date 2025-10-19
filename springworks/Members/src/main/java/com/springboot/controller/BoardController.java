package com.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.dto.BoardDTO;
import com.springboot.entity.Board;
import com.springboot.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/boards")
@Controller
public class BoardController {
	
	private final BoardService service;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm() {
		return "board/write";
	}
	
	//글쓰기 
	@PostMapping("/write")
	public String write(@ModelAttribute BoardDTO dto) {
		//System.out.println("BoardDTO: " + dto);
		
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




