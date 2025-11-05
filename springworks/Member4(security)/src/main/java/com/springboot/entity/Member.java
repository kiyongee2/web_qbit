package com.springboot.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springboot.dto.MemberDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@CreationTimestamp
	private Timestamp joinDate;
	
	@Column(nullable=false)
	private String role;
	
	//양방향 매핑
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
	private List<Board> boards = new ArrayList<>();
	
	//DTO를 Entity로 변환하는 메서드
	public static Member toSaveEntity(MemberDTO dto, 
			PasswordEncoder encoder) {
		Member member = new Member();
		member.setEmail(dto.getEmail());
		member.setPasswd(encoder.encode(dto.getPasswd()));
		member.setName(dto.getName());
		member.setGender(dto.getGender());
		member.setRole("ROLE_USER");
		
		return member;
	}
}

