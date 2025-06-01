package com.sec01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// 페이지 클릭 할 때마다 (컨트롤러 테스트) 콘솔에서 log 확인 가능
	@Before("execution(* com.sec01..*Controller.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("<===진입: "+joinPoint.getSignature().toShortString());
	}
	
	@AfterReturning("execution(* com.sec01..*Controller.*(..))")
	public void logAfter(JoinPoint joinpoint) {
		System.out.println("===> 종료 : " + joinpoint.getSignature().toShortString());
	}
}
