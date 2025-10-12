package com.file.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Member {
	private String name;
	private MultipartFile fileImage;
}
