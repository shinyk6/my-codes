package com.test01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	 @Bean 
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { 
		 System.out.println("--------filterChain-------");
		 // authenticated 규칙 / 로그인 권한 / 로그아웃 권한
	        http.csrf(csrf->csrf.disable()) //세션 기반이 아닌 토큰 기반으로 진행하기 때문에 비활성화
	        		.authorizeHttpRequests(auth -> 
	        				auth.requestMatchers("/", "/index", "/login", "/register", "/h2-console/**").permitAll()  //permitAll() : 접근권한 풀기 - 인증 없이 허용하겠다.
	        				.anyRequest().authenticated()) //나머지는 요청은 반드시 인증해야함
	        		.formLogin(login 
	        				 -> login.loginPage("/login")  //인증을 할 수 있게 login view로 리디렉트
	        				 .defaultSuccessUrl("/home", true).permitAll()) //ture - 항상  인증 성공하면 항상 home으로 리디렉트, 접근허용
	           
	        		.logout(logout -> logout.logoutSuccessUrl("/index").permitAll()); //로그아웃 자체는 모든 사용자에게 허용
	        return http.build();   //build의 객체로 필터체인을 리턴
	    } 
	 
	 
	    @Bean 
	    public PasswordEncoder passwordEncoder() { 
	        return new BCryptPasswordEncoder(); //패스워드 전용 해쉬 코드 -> 비밀번호 암호화하겠다
	    }
}
