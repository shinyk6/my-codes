package com.mydb.core;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


public class LogAspect {

	//트랜잭션 시작하는 부분
	@Before("execution(* com.mydb.core.EmpService.*(..))")
    public void before(JoinPoint jp) {
        System.out.println("[AOP] Before: " + jp.getSignature().getName());
    }

	
    //트랜잭션이 종료되는 부분 .   커밋된 이후의 작업을 진행 시 ... / 롤백 된 이후의 작업 (Throwing메소드 작업해서 구현)
	@After("execution(* com.mydb.core.EmpService.*(..))")
    public void after(JoinPoint jp) {
        System.out.println("[AOP] After: " + jp.getSignature().getName());
    }
}
