package com.test06;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* com.test06.Student.*(..))") //Pointcut한번만 선언해서 사용
	public void allMethods() {} // 가안으로 대처할 수 있는 포인트 컷이 있는 메소드를 만들어줌
	
	@Before("allMethods()" )
	public void before(JoinPoint joinpoint) {
		System.out.println("[AOP] 메소드 실행 전 : " + joinpoint.getSignature().getName());
	}
	
	@After("allMethods()") //finally -> 반드시 수행할 명령, 작업
	public void after(JoinPoint joinpoint) {
		System.out.println("[AOP] 메소드 실행 후 : " + joinpoint.getSignature().getName());	
	}
	
	// 대상메소드가 정상적으로 실행했을 경우(예외 발생하면 실행X) //후 처리 할 때 사용
	@AfterReturning(pointcut="allMethods()", returning="retVal")
	public void doAccessCheck(Object retVal) {
		System.out.println("@AfterReturning [AOP] 메소드 실행 후 : "+retVal);
	}
}
