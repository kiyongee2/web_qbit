package com.springboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	//도서 목록
	public List<Book> getAllBookList(){
		return bookRepository.getAllBookList();
	}
	
	//도서 상세
	public Book getBookById(String bookId) {
		return bookRepository.getBookById(bookId);
	}
	
	//도서 분야
	public List<Book> getBookListByCategory(String category){
		return bookRepository.getBookListByCategory(category);
	}
	
	//도서 분야와 출판사
	public Set<Book> getBookListByFilter(Map<String, List<String>> filter){
		Set<Book> booksByFilter = bookRepository.getBookListByFilter(filter);
		return booksByFilter;
	}
	
	//도서 등록
	public void setNewBook(Book book) {
		bookRepository.setNewBook(book);
	}
}











