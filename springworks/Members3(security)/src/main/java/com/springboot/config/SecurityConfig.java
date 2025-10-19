package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.springboot.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity // 메소드 레벨 권한 사용시 필요
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/members/join", "/members/login", "/boards/pages",
                		"/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/members/**").hasAnyRole("USER","ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/members/login")
                .loginProcessingUrl("/perform_login") // 로그인 POST 액션 URL
                .defaultSuccessUrl("/", true)
                .failureUrl("/members/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/perform_logout")   // POST default 권장
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            )
            .authenticationProvider(authenticationProvider(passwordEncoder()));

        return http.build();
    }
}

