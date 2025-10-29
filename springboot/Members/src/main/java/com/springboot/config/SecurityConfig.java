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
					.requestMatchers("/", "/css/**", "/images/**",
							"/members/join", "/members/login").permitAll() //해당 경로만 허용
					.requestMatchers("/members/**").hasAnyRole("USER","ADMIN") //둘 모두 허용
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()    //나머지는 인증 필요
			)
			.formLogin(form -> form
				.loginPage("/members/login")  //사용자 로그인 페이지
				.permitAll()          //누구나 접근 가능
			)
			.logout(logout -> logout  //로그 아웃
	            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
	                .logoutSuccessUrl("/")
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
}
