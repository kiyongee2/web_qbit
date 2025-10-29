package com.springboot.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.entity.Member;

//UserDetails을 구현한 CustomUserDetails
public class CustomUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Member member;
	
	public CustomUserDetails(Member member) {
		this.member = member;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//권한 반환
		return Collections.singletonList(
				new SimpleGrantedAuthority(member.getRole())
		);
	}

	@Override
	public String getPassword() {
		return member.getPasswd();
	}

	@Override
	public String getUsername() {
		return member.getEmail();
	}
	
	//Member 접근용 getter
	public Long getId() {
		return member.getId();
	}
	
	public String getName() {
		return member.getName();
	}
}





