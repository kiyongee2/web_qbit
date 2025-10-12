package com.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean //비밀번호 암호화
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//사용자 계정 설정 - In memory 
	@Bean
	UserDetailsService userDetailService() {
		UserDetails user = User.builder()
			.username("guest")
			.password(passwordEncoder().encode("g1234"))
			.roles("USER")
			.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("a1234"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	//접근 권한 설정
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(auth -> auth
				.requestMatchers("/auth", "/login", "/home/**").permitAll()
	            .requestMatchers("/member/**").hasRole("USER")
	            .requestMatchers("/admin/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")      // 사용자 로그인 페이지(ID:user, PW:제공된 암호) 
				.permitAll()              // 로그인 페이지는 누구나 접근 가능
			)
			.logout(logout -> logout
				.logoutUrl("/logout")  //로그아웃 경로
				.permitAll()); // 로그아웃도 허용
	
		return http.build();
	}
	
}














