package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

@Controller //현재 클래스는 웹 요청을 처리하는 컨트롤러이다
public class DemoController {
//	@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 보내자
//	String index(@PathVariable int num, Model model) {
//		int sum = 0;
//		for(int i = 1; i <= num; i++) {
//			sum += i;
//		}
//		model.addAttribute("msg", "sum="+sum);	//msg = "sum="+sum
//		
//		
//		return "index"; // src/main/resources/templates/index.html (view name)
//	}
	
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