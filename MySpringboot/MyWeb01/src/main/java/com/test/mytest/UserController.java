package com.test.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.PostConstruct;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repos;
	
	//[1] 사용자 목록 + 폼페이지 (GET)
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("data", repos.findAll());
		return mav;
	}
	
	//[2] 사용자 저장 (POST)   //insert이기에 트랜잭션 필요
	@RequestMapping(value="/", method=RequestMethod.POST)
	@Transactional(readOnly = false) //현재 트랜잭션 내에서 쓰기 작업(저장 수정 삭제) 허용
	public ModelAndView index(@ModelAttribute("formModel") User user) { //form데이터를 User객체에 넣겠다.
		repos.saveAndFlush(user); //사용자 데이터를 입력받아 즉시 DB에 저장 및 반영
		return new ModelAndView("redirect:/");  //데이터 저장 후 목록 화면으로 다시 이동 
												//-> 새로고침 했을 때 폼 데이터 재전송 경고 뜨는 것을 방지
												//-> 새로 저장된 데이터(최신사용자목록)를 다시 불러와서 표시
												// redirect : 다시 이동해라
	}
	
	//[3] 초기 사용자 등록 
	@PostConstruct
	public void Init() {
		User user1 = new User();
		user1.setName("홍길동");
		repos.saveAndFlush(user1); //save하고 메모리 지워주는 메소드
		
		
		User user2 = new User();
		user2.setName("정길동");
		repos.saveAndFlush(user2);
		
		
	}
}
