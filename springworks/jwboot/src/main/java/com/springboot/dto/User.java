package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor //매개변수를 모두 가진 생성자
@NoArgsConstructor  //기본 생성자
@ToString //문자열 정보
@Setter   //setter
@Getter   //getter
public class User {
	private String id;  //아이디
    private String pw;  //비밀번호
}


