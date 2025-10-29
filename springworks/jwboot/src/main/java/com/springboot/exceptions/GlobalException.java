package com.springboot.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//모든 컨트롤러에서 발생하는 예외를 일괄 처리함
@ControllerAdvice  //전역 예외 처리
public class GlobalException {

	@ExceptionHandler
	private String handleErrorMethod(Exception ex, Model model) {
		model.addAttribute("data1", "GlobalException 메시지입니다.");
		model.addAttribute("data2", ex);
		return "exception/viewPage02";
	}
}

