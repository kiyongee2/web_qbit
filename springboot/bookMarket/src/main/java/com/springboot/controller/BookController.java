package com.springboot.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.domain.Book;
import com.springboot.service.BookService;

@RequestMapping("/books")
@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//도서 목록
	@GetMapping("/all")
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	//도서 상세
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookById(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	//도서 분야
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory,
			Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		return "books";
	}
	
	//도서 분야와 출판사
	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar = "bookFilter") 
			Map<String, List<String>> bookFilter, Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
		model.addAttribute("bookList", booksByFilter);
		return "books";
	}
	
	//도서 등록 폼  
	@GetMapping("/add")
	public String requestAddBookForm() {
		return "addBook";
	}
	
	//도서 등록 처리
	@PostMapping("/add")
	public String submitNewBook(@ModelAttribute Book book) {
		bookService.setNewBook(book);
		return "redirect:/books/all";
	}
}












