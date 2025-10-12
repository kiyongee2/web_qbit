package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
