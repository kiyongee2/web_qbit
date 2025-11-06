package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.dto.MemberDTO;
import com.springboot.entity.Member;
import com.springboot.exception.UserException;
import com.springboot.repository.MemberRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberRepository repository;
	private final PasswordEncoder pwEncoder;
	
	//회원 추가
	public void save(MemberDTO dto) {
		if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
		//DTO를 Entity로 변환 메서드 호출
		Member member = Member.toSaveEntity(dto, pwEncoder);
		repository.save(member);
	}

	//회원 목록
	public List<Member> findAll() {
		return repository.findAll();
	}

	//회원 정보
	public Member findById(Long id) {
		//예외 처리
		Member findMember = 
				repository.findById(id)
					.orElseThrow(() -> {
						throw new UserException("존재하지 않는 회원입니다.");
					});
		return findMember;
	}

	//회원 삭제
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

