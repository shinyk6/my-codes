package com.test03;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect // 핵심 + 공통 로직을 분리해서 구현하는 클래스 // 부가 기능을 작성하는 곳
@Component
public class MyAspect { 
	//// Advice를 지정한다.	: 특정 JoinPoint에서 실행되는 실제 동작들을 @으로 지정한다.

	// classWork의 before
	@Before("execution(public void com.test03.*.classWork(..))") // pointcut -> advice가 적용되는 특정 지점에 대한 표현식
	public void before(JoinPoint joinPoint) { //JoinPoint : 메소드 실행 정보
		System.out.println("[AOP] 줌인 합니다. 출석 확인." + joinPoint.toString()); 

	}

	@AfterThrowing(pointcut = "execution(public void com.test03.*.classWork(..))", throwing="e")
	public void throwing(JoinPoint joinPoint, Throwable e) {  // e=res

		System.out.println("학습 중 오류가 발생했습니다." + e.getMessage());
	}

	@After("execution(public void com.test03.*.classWork(..))") //classWork의 after
	public void after(JoinPoint joinPoint) {
		System.out.println("줌 로그아웃 합니다."); 
	}

}
