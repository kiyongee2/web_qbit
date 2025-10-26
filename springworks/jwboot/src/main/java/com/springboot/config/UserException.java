package com.springboot.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)  //404 오류
public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserException(String message) {
		super(message);
		System.out.println(message);
	}
	
	
}
