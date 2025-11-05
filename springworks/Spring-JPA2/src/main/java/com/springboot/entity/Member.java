package com.springboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "boards") //순환 참조 오류 방지
@Setter
@Getter
@Entity
public class Member {
	@Id  //PRIMARY KEY(기본키)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;  //번호
	
	@Column(unique = true)
	private String memberId; //회원 아이디
	
	@Column(nullable = false)
	private String password; //비밀번호
	
	@Column(nullable = false)
	private String name;   //이름
	
	private String role;   //권한(USER, ADMIN)
	
	// Member(일) : Board(다)와 연관 매핑 :
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Board> boards = new ArrayList<>();
}




