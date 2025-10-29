package com.springboot.dto;

import java.sql.Timestamp;

import com.springboot.entity.Member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberDTO {
	private Long id;
	private String email;
	private String passwd;
	private String name;
	private String gender;
	private String role;
	private Timestamp joinDate;
	
	//entity를 dto로 변환 메서드
	/*public static MemberDTO toSaveDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(member.getId());
		memberDTO.setPasswd(member.getPasswd());
		memberDTO.setEmail(member.getEmail());
		memberDTO.setName(member.getName());
		memberDTO.setGender(member.getGender());
		memberDTO.setJoinDate(member.getJoinDate());
		
		return memberDTO;
	}*/
}






