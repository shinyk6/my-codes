package com.test04;

import org.aspectj.lang.JoinPoint;


public class MyAspect { 

	public void before(JoinPoint joinPoint) { //JoinPoint : 메소드 실행 정보
		System.out.println("[AOP] 줌인 합니다. 출석 확인." + joinPoint.toString()); 

	}


	public void throwing(JoinPoint joinPoint, Throwable e) {  // e=res

		System.out.println("학습 중 오류가 발생했습니다." + e.getMessage());
	}


	public void after(JoinPoint joinPoint) {
		System.out.println("줌 로그아웃 합니다."); 
	}

}
