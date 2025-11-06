package com.springboot.exception;

//사용자 정의 예외 처리
public class UserException extends RuntimeException{

	public UserException(String message) {
		super(message);
		
	}

}
