package com.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//사용자 정의 예외는 RuntimeException을 상속 받아야 함
@ResponseStatus(value=HttpStatus.NOT_FOUND)  //404 오류
public class UserException extends RuntimeException{

	public UserException(String message) {
		super(message);
	}
}
