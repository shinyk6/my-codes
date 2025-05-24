package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //현재 클래스는 웹 요청을 처리하는 컨트롤러이다
public class DemoController {

	
	//[1] GET 요청 : 폼 화면 출력
	@GetMapping("/")
	public ModelAndView showForm(ModelAndView mav) {
		mav.addObject("msg", "숫자를 입력하시오");
		mav.addObject("value","");
		mav.setViewName("index");
		return mav;
	}
	
	//[2] POST 요청 : 폼에서 받은 값을 처리
	//사용자가 html 폼에 입력한 숫자를 받아 합을 구하고 그 결과 메시지를 html전달 화면 출력
	@PostMapping("/") //<form method="post" action="/">
	ModelAndView handleForm(@RequestParam String text1, ModelAndView model) { //폼의 name="text1"
		//@RequestParam /요청이 들어올 때 
		int sum = 0;
		int num = Integer.parseInt(text1);
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		model.addObject("msg", "sum="+sum); //데이터 담고
		model.addObject("value", text1);
		model.setViewName("index"); //뷰 이름 지정
		return model;
	}	
	
	
	//[3] URL 직접 입력 방식 테스트
	@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 보내자
	ModelAndView index(@PathVariable int num, ModelAndView model) {
		int sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		model.addObject("msg", "sum="+sum); //데이터 담고
		model.setViewName("index"); //뷰 이름 지정
		return model;
	}	
}