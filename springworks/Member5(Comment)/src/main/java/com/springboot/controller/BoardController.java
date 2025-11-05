package com.springboot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.dto.BoardDTO;
import com.springboot.dto.CommentDTO;
import com.springboot.entity.Board;
import com.springboot.service.BoardService;
import com.springboot.service.CommentService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/boards")
@Controller
public class BoardController {
	private final BoardService service;
	private final CommentService commentService;
	
	//글쓰기 페이지
	@GetMapping("/write")
	public String writeForm(BoardDTO boardDTO) {
		log.info("Has errors...");
		return "board/write";
	}
	
	//글쓰기 처리
	@PostMapping("/write")
	public String write(@Valid BoardDTO dto,
			BindingResult bindingResult,
			Model model) {
		if(bindingResult.hasErrors()) {
			return "board/write";
		}
		service.save(dto);
		return "redirect:/boards/pages";
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
	/*@GetMapping("/pages")
	public String getBoardPage(
			@PageableDefault(page=1) Pageable pageable,
			Model model) {
		Page<Board> boardList =
			boardList = service.findAll(pageable);

		//하단의 페이지 블럭
		int blockLimit = 10;
		
		//시작 페이지 - 1, 2, 3...
		//시작 번호 -   1, 11, 21...
		//예) 번호 - 13,  13/10-1.3 -> 2(올림)-1 * 10 + 1 => 11
		int startPage 
			= ((int)Math.ceil((double)pageable.getPageNumber() / blockLimit)-1) 
				* blockLimit + 1;
		//페이지의 행번호(끝) 10, 20, 30...
		//int endPage = startPage + blockLimit - 1;
		int endPage = (startPage + blockLimit - 1) > boardList.getTotalPages() ?
				boardList.getTotalPages() : (startPage + blockLimit - 1);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		return "board/pages";
	}*/
	
	//글목록(제목 검색, 페이지 처리)
	/*@GetMapping("/pages")
	public String getBoardPage(
			//false -> 키워드가 없어도 목록 보임, required -> true이면 오류 발생
			@RequestParam(value="keyword", required=false) String keyword,
			@PageableDefault(page=1) Pageable pageable,
			Model model) {
		Page<Board> boardList = null;
		if(keyword == null) {
			boardList = service.findAll(pageable);
		}else {
			boardList = service.findByTitleContaining(keyword, pageable);
		}
		
		//하단의 페이지 블럭
		int blockLimit = 10;
		
		//시작 페이지 - 1, 2, 3...
		//시작 번호 -   1, 11, 21...
		//예) 번호 - 13,  13/10-1.3 -> 2(올림)-1 * 10 + 1 => 11
		int startPage 
			= ((int)Math.ceil((double)pageable.getPageNumber() / blockLimit)-1) 
				* blockLimit + 1;
		//페이지의 행번호(끝) 10, 20, 30...
		//int endPage = startPage + blockLimit - 1;
		int endPage = (startPage + blockLimit - 1) > boardList.getTotalPages() ?
				boardList.getTotalPages() : (startPage + blockLimit - 1);
		
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("kw", keyword);  //검색어 보냄
		
		return "board/pages";
	}*/
	
	//글목록(제목과 내용 검색, 페이지 처리)
	@GetMapping("/pages")
	public String getBoardPage(
			//false -> 키워드가 없어도 목록 보임, required -> true이면 오류 발생
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="type", required=false) String type,
			@PageableDefault(page=1) Pageable pageable,
			Model model) {
		Page<Board> boardList = null;
		if(keyword == null) {
			boardList = service.findAll(pageable);
		}else if(keyword != null && type.equals("title")){
			boardList = service.findByTitleContaining(keyword, pageable);
		}else if(keyword != null && type.equals("content")) {
			boardList = service.findByContentContaining(keyword, pageable);
		}
		
		//하단의 페이지 블럭
		int blockLimit = 10; //1 2 3 ... 10 (10페이지까지 보이기)
		//페이지 블럭의 시작 번호 -  1, 11, 21
		//예)페이지 번호 - 13,  13/10=1.3-> 2(올림)-1 * 10 + 1 => 11 (11 ~ 20 블럭)
		int startPage = 
				((int)Math.ceil((double)pageable.getPageNumber() / blockLimit) - 1)
				* blockLimit + 1;
		
		//페이지 블럭의 끝번호 - 10, 20, 30
		//int endPage = startPage + blockLimit - 1  (

		/*int endPage = (startPage + blockLimit - 1) > boardList.getTotalPages() ?
				boardList.getTotalPages() : (startPage + blockLimit - 1);*/
		
		int endPage = Math.min(startPage + blockLimit - 1, boardList.getTotalPages());
		
		log.info("startPage: " + startPage);
		log.info("pageable.getPageNumber(): " + pageable.getPageNumber());
		log.info("endPage: " + endPage);
		log.info("boardList.getTotalPages(): " + boardList.getTotalPages());
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("type", type);  //검색 유형
		model.addAttribute("kw", keyword);  //검색어 
		
		return "board/pages";
	}

	//글 상세보기
	@GetMapping("/{id}")
	public String getBoard(@PathVariable Long id,
			@PageableDefault(page=1) Pageable pageable,
			Model model) {
		try {
			//조회수 증가
			service.updateHits(id);
			//글 상세 보기
			Board board = service.findById(id);
			//댓글 목록 가져오기
			List<CommentDTO> commentDTOList = commentService.findAll(id);
			//모델 보내기
			model.addAttribute("board", board);
			model.addAttribute("page", pageable.getPageNumber());
			model.addAttribute("commentList", commentDTOList);
			return "board/detail";
		}catch(Exception e) {
			model.addAttribute("errorMsg", e.getMessage());
			return "error/errorPage";
		}
	}
	
	//글 삭제
	@GetMapping("/delete/{id}")
	public String deleteBoard(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/boards/pages";
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
	
	// 파일 다운로드
    @GetMapping("/download/{id}")
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) throws IOException {
        Board board = service.findById(id);
        String filePath = "c:/upload/" + board.getStoredFilename();
        File file = new File(filePath);

        if (!file.exists()) {
            response.getWriter().write("파일이 존재하지 않습니다.");
            return;
        }

        String encodedName = URLEncoder.encode(board.getOriginalFilename(), StandardCharsets.UTF_8);
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedName);

        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
        	//파일을 읽어와서 쓰기(저장)
            in.transferTo(out);
        }
    }
}




