package com.springboot.dto;

import java.sql.Timestamp;

import com.springboot.entity.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberDTO {
	private Long id;
	private String email;
	private String passwd;
	private String name;
	private String gender;
	private Timestamp joinDate;
}






