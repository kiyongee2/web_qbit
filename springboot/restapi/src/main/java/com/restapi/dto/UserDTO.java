package com.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

	private Integer id;
	private String username;
	private String password;
	private String email;
}
