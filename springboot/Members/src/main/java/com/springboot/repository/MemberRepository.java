package com.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

	//쿼리 메서드 - 메서드 이름이 쿼리임
	Optional<Member> findByEmail(String email);
}
