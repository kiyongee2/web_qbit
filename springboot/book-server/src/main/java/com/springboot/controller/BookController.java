package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Book;
import com.springboot.service.BookService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/books")
@RequiredArgsConstructor
@RestController
public class BookController {

	private final BookService bookService;
	
	//도서 등록
	/*@PostMapping("/save")
	public String saveBook(@RequestBody Book book) {
		bookService.save(book);
		return "도서 등록 완료!";
	}*/
	
	//도서 등록
	//ResponseEntity<?> = body + header
	@PostMapping("/save")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		bookService.save(book);
		return new ResponseEntity<>("도서 등록 완료!", HttpStatus.OK);
	}
	
	//도서 목록
	@GetMapping
	public ResponseEntity<?> getBookList(){
		List<Book> bookList = bookService.findAll();
		return new ResponseEntity<>(bookList, HttpStatus.OK);
	}
	
	//도서 정보(상세보기)
	@GetMapping("/{id}")
	public ResponseEntity<?> getBook(@PathVariable Long id){
		Book book = bookService.findById(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	//도서 삭제
	@DeleteMapping("/{id}")
	public ResponseEntity<?> saveBook(@PathVariable Long id) {
		bookService.delete(id);
		return new ResponseEntity<>("도서 삭제 완료!", HttpStatus.OK);
	}
	
	//도서 수정
	//ResponseEntity<?> = body + header
	@PutMapping("/save")
	public ResponseEntity<?> updateBook(@RequestBody Book book) {
		bookService.update(book);
		return new ResponseEntity<>("도서 수정 완료!", HttpStatus.OK);
	}
}







