package com.springboot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	private List<MemberDTO> list = new ArrayList<>();
	private long sequence = 0L;
	
	//회원 등록
	public MemberDTO save(MemberDTO dto) {
		dto.setId(++sequence);
		list.add(dto);
		return dto;
	}
	
	//회원 목록
	public List<MemberDTO> findAll(){
		return list;
	}
}










