package com.springboot.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Product {
	
	@NotEmpty
	@Size(min=4, max=10, message="4자~10자 이내로 입력해 주세요.")
	private String name;
	
	@Min(value=0, message="0 이상의 값을 입력해 주세요")
	private int price;
}
