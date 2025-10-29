package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
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

import com.springboot.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	private final CustomUserDetailsService userDetailsService;
	
	@Bean  
    public DaoAuthenticationProvider 
    		authenticationProvider(PasswordEncoder encoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/css/**", "/images/**",
							"/members/join", "/members/login").permitAll() 
					//USER, ADMIN 권한 모두 허용
					.requestMatchers("/members/**").hasAnyRole("USER","ADMIN") 
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()    //나머지는 인증 필요
			)
			.formLogin(form -> form
					.loginPage("/members/login")
	                .loginProcessingUrl("/login") // 로그인 POST 액션 URL
	                .defaultSuccessUrl("/", true)
	                .failureUrl("/members/login?error=true")
	                .permitAll()
			)
			.logout(logout -> logout  //로그 아웃
	            	.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
	                .logoutSuccessUrl("/")
	                .invalidateHttpSession(true)
	                .deleteCookies("JSESSIONID")
	         )
			.exceptionHandling(ex -> ex
					.accessDeniedPage("/access-denied"));
		
		return http.build();
	}
	
	//비밀번호 암호화
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

