package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	//이메일을 찾아서 Member를 반환하는 메서드
	Optional<Member> findByEmail(String email);
}

