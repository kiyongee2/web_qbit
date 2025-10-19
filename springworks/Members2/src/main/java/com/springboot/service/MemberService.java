package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.dto.MemberDTO;
import com.springboot.entity.Member;
import com.springboot.repository.MemberRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
	
	MemberRepository repository;
	
	//회원 추가
	public void save(MemberDTO dto) {
		if (repository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
		//DTO를 Entity로 변환 메서드 호출
		Member member = Member.toSaveEntity(dto);
		repository.save(member);
	}

	//회원 목록
	public List<Member> findAll() {
		return repository.findAll();
	}

	//회원 정보
	public Member findById(Long id) {
		/*Optional<Member> member = repository.findById(id);
		return member.orElse(null);*/
		//예외 처리
		return repository.findById(id)
				.orElseThrow(
					() -> new IllegalArgumentException("회원이 존재하지 않습니다. ID=" + id));
	}

	//회원 삭제
	public void delete(Long id) {
		repository.deleteById(id);
	}

	//로그인
	public MemberDTO login(String email, String passwd) {
		Member member = repository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!member.getPasswd().equals(passwd)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        
        MemberDTO dto = new MemberDTO();
        dto.setId(member.getId());
        dto.setEmail(member.getEmail());
        dto.setName(member.getName());
        dto.setGender(member.getGender());
        return dto;
	}
}
