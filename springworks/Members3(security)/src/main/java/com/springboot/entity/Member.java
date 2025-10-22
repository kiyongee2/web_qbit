package com.springboot.entity;

import java.sql.Timestamp;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.dto.MemberDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "t_member")
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
	
	@Column(nullable=false)
	private String role;
	
	//DTO를 Entity로 변환
	public static Member toSaveEntity(MemberDTO dto,
			PasswordEncoder encoder) {
		Member m = new Member();
		m.setEmail(dto.getEmail());
		m.setPasswd(encoder.encode(dto.getPasswd()));
		m.setName(dto.getName());
		m.setGender(dto.getGender());
		m.setJoinDate(new Timestamp(System.currentTimeMillis()));
		m.setRole("ROLE_USER");
		
		return m;
	}
}
