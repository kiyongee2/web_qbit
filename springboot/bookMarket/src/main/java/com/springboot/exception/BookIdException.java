package com.springboot.exception;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class BookIdException {
	private String bookId;
	
	public BookIdException(String bookId) {
		this.bookId = bookId;
	}

}
