package com.test01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test01.entity.Member;
import com.test01.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor   // 1. 생성자 값 주입 명시 할 때  2. 컬럼에 NotNull처리 @선언 시    (memberRepository 주입을 제대로 하도록) 
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	 private MemberRepository memberRepository; 
	 
    @Override //UserDetailsService의 메소드를 재정의 - 사용자 정보를 UserDetails라는 객체로 받아온다. (정해져있음)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	//엔티티로 데이터를 추출한 Member의 각 필드를 User객체에 담아서 생성 build() 하게 되면 UserDetails가 됨. (나의 멤버 정보를 User로 감싸서 UserDetails객체로 보안관리)
    	// member -> User -> UserDetails
    	
        Member member = memberRepository.findByUsername(username) 
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다.")); 
        
 
        return User.builder() 
                .username(member.getUsername()) 
                .password(member.getPassword()) 
                .roles(member.getRole().replace("ROLE_", "")) 
                .build(); 
    }
}
