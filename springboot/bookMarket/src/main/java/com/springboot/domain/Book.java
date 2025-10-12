package com.springboot.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Book {
	private String bookId;
	private String name;
	private BigDecimal unitPrice;
	private String author;
	private String description;
	private String publisher;
	private String category;
	private BigDecimal unitsInStock;
	private String releaseDate;
	private String condition;
}
