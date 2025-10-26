package com.springboot.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.entity.Member;

//CustomUserDetails.java
public class CustomUserDetails implements UserDetails {
	 private static final long serialVersionUID = 1L;
	
	 private final Member member;

	 public CustomUserDetails(Member member) {
	     this.member = member;
	 }

	 @Override
	 public Collection<? extends GrantedAuthority> getAuthorities() {
	     return Collections.singletonList(new SimpleGrantedAuthority(member.getRole()));
//		 return Collections.singletonList(
//		    new SimpleGrantedAuthority("ROLE_" + member.getRole())
//		);
	 }
	
	 @Override
	 public String getPassword() {
	     return member.getPasswd();
	 }
	
	 @Override
	 public String getUsername() {
	     return member.getEmail();
	 }
	
	 @Override
	 public boolean isAccountNonExpired() { return true; }
	
	 @Override
	 public boolean isAccountNonLocked() { return true; }
	
	 @Override
	 public boolean isCredentialsNonExpired() { return true; }
	
	 @Override
	 public boolean isEnabled() { return true; }
	
	 // 추가로 Member 정보 접근용 getter
	 public Long getId() { return member.getId(); }
	 public String getName() { return member.getName(); }
	 
}

