package com.sec06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

	@Autowired
	private AsyncService asyncService;
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		asyncService.processAsync(name);
		return "요청 완료됨 (비동기 처리 시작)";
	}
}
