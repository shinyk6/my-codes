package com.lab02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;



@RestController
@RequestMapping("/test")
public class TestExceptionController {
	
	// (1) 유효성 검증 실패 처리
	
	
	// (2) 엔티티 찾지 못했을 때 처리
	@GetMapping("/notfound")
	public String notFount() {
		throw new EntityNotFoundException("엔티티를 찾을 수 없어!!!");
	}
	
	// (3) 그 외에 예외 처리
	@GetMapping("/other")
	public String testException() throws Exception {
		throw new Exception("기타 등등 예외");
	}
}
