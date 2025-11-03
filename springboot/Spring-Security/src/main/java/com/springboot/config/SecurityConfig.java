package com.springboot.config;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(auth -> auth
				//해당 경로만 허용
				.requestMatchers("/", "/auth", "/home/**").permitAll() 
				.requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().authenticated() //나머지는 인증 필요
			)
			.formLogin(form -> form
				.loginPage("/login")  //사용자 로그인 페이지
				.permitAll()          //누구나 접근 가능
			)
			.logout(logout -> logout  //로그 아웃
	            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
	                .logoutSuccessUrl("/auth")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	            );
		
		return http.build();
	}
	
	//비밀번호 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//사용자 계정 - in memory
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
		
		return new InMemoryUserDetailsManager(user, admin );
	}
}

