package com.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

	private Integer id;  //번호
	private String username; //아이디
	private String password; //비빌번호
	private String email;    //이메일
	
	
}
