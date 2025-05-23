package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller //현재 클래스는 웹 요청을 처리하는 컨트롤러이다
public class DemoController {
	@RequestMapping("/") // "/"의 경로로 들어오는 요청을 처리
	String index() {
		return "index"; // src/main/resources/templates/index.html (view name)
	}
}
