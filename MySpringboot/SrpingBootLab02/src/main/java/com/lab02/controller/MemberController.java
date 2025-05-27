package com.lab02.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab02.entity.Member;
import com.lab02.service.MemberService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public List<Member> getAllMembers(){
		return memberService.getAllMembers();
	}
	
	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable Long id) {
		return memberService.getMemberById(id);
	}
	
	@PostMapping
	public Member createMember(@Valid @RequestBody Member member) { //@Vaild : 대상 객체의 확인 조건을 만족할 경우 통과 가능
																//@RequestBody : 클라이언트가 보낸 JSON본문(body)를 java객체로 변환해줌 (member는 JSON에서 변환된 자바 객체)
																// 즉 JSON -> Java 를 RequestBody가 해주는 것
																//JSON본문을 받을 때만 사용 - URL파라미터나 폼데이터는 안써도 됨
		return memberService.saveMember(member);
	}

	@PutMapping("/{id}")
	public Member updateMember(@PathVariable Long id, @Valid @RequestBody Member member) {
		return memberService.updateMember(id, member);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMember(@PathVariable Long id) {
		memberService.deleteMember(id);
	}
}
