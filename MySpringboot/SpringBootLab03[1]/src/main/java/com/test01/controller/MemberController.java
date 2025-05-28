package com.test01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test01.entity.Member;
import com.test01.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		model.addAttribute("member", new Member());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Member member) {
		memberService.register(member);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	// 전체 회원 조회 (JSON응답)
	public List<Member> getAllMember(){
		return null;
	}
	
	//로그인 하면 화면에 00님 환영합니다 
	//==전체 멤버 내림차순으로 5개만출력==
	@GetMapping("/home")
	public String home(Model model) {
		List<Member> members = memberService.getTop5Member();
		model.addAttribute("members", members);
		return "home";
	}
}
