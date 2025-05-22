package com.workshop04.test01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect{

	@Before("execution(public void com.workshop04.test01.*.study(..))")
	public void before(JoinPoint joinpoint) {
		System.out.println("[AOP] 공부 시작합니다.");
	}
	
}
