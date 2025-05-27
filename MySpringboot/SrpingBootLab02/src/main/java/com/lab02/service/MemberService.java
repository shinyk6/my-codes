package com.lab02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab02.entity.Member;
import com.lab02.repository.MemberRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
	//전체 회원 목록 조회
	public List<Member> getAllMembers(){ 
		return memberRepository.findAll();
	}
	
	//특정 ID의 회원을 조회
	public Member getMemberById(Long id) {
		return memberRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Member not found"));
	}
	
	// 새로운 회원 정보를 저장
	public Member saveMember(Member member) {
		return memberRepository.saveAndFlush(member);
	}
	
	//기존 회원의 정보를 수정
	public Member updateMember(Long id, Member member) {
		Member existing = getMemberById(id);
		existing.setName(member.getName());
		existing.setEmail(member.getEmail());

		return memberRepository.save(existing) ;
	}
	
	//특정 ID의 회원을 삭제
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}
