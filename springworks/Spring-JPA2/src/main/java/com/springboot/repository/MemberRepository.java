package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	public Member findByMemberId(String memberId);
}

