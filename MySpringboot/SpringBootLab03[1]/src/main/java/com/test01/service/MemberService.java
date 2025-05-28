package com.test01.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test01.entity.Member;
import com.test01.repository.MemberRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
//@RequiredArgsConstructor
public class MemberService { //회원가입 서비스
	 @Autowired
	 private MemberRepository memberRepository; 
	
	 @Autowired
	 private PasswordEncoder passwordEncoder; 
 
	 @Transactional //DB적용
	  public Member register(Member member) {         
		  //암호화된 패스워드를 가진 멤버를 insert
		  member.setPassword(passwordEncoder.encode(member.getPassword())); //원본 비밀번호를 BCrypt 해시값으로 변환
		  return memberRepository.save(member); 
	  } 
	 
	 //내림차순 멤버 5명만 조회
	 public List<Member> getTop5Member(){
		 System.out.println("5명 조회");
		 return memberRepository.findTop5ByOrderByIdDesc();
	 }
}
