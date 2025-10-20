package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString  //문자열 정보
@NoArgsConstructor   //기본 생성자
@AllArgsConstructor  //매개변수를 모두 가진 생성자
@Setter   //setter
@Getter   //getter
public class MemberDTO {
	private Long id;      //순번
	private String name;  //이름
	private String email; //이메일
}

