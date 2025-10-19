package com.springboot.entity;

import java.sql.Timestamp;

import com.springboot.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.Data;

@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String email;
	
	@Column(nullable=false)
	private String passwd;
	
	@Column(length=30, nullable=false)
	private String name;
	
	@Column(length=10)
	private String gender;
	
	@Column
	private Timestamp joinDate;
	
	//DTO를 Entity로 변환
	public static Member toSaveEntity(MemberDTO dto) {
		Member member = new Member();
		member.setEmail(dto.getEmail());
		member.setPasswd(dto.getPasswd());
		member.setName(dto.getName());
		member.setGender(dto.getGender());
		member.setJoinDate(new Timestamp(System.currentTimeMillis()));
		
		return member;
	}
}
