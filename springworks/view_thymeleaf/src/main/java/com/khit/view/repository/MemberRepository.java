package com.khit.view.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.khit.view.model.Member;

@Repository
public class MemberRepository {
	
	private List<Member> list = new ArrayList<>();
	private long sequence = 0L;
	
	//회원 목록
	public List<Member> findAll(){
		return list;
	}
	
	//회원 등록
	public Member save(Member member) {
		member.setId(++sequence);
		list.add(member);
		return member;
	}
}










