package com.sec02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	private AsyncUserService userService;
	
	@GetMapping("/register")
	public String register(@RequestParam String username) {
		userService.registerUser(username);  //service가 실행되면 이벤트 실행
		return "User registered (sync) : " + username;
	}
}
