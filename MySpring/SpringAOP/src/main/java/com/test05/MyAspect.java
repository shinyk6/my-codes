package com.test05;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint joinpoint) {
		System.out.println("[AOP] 메소드 실행 전 : " + joinpoint.getSignature().getName());
	}
	
	public void after(JoinPoint joinpoint) {
		System.out.println("[AOP] 메소드 실행 후 : " + joinpoint.getSignature().getName());
		
	}
	
}
