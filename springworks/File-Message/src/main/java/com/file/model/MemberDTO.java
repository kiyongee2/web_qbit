package com.file.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class MemberDTO {
	private String name;
	private MultipartFile fileImage;
}



