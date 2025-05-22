package com.test02;


import org.aopalliance.intercept.MethodInterceptor; //메소드 호출을 가로채기한 다음 부가 정보를 추가로 구현하는 인터페이스
import org.aopalliance.intercept.MethodInvocation; //실행되는 메소드가 있다면 정보를 담아서 저장하는 객체  -> 메소드이름(매개인자)

public class MyAspect implements MethodInterceptor { //MyAspect자체가 메소드 가로채기 하는 클래스
	
	@Override
	public Object invoke(MethodInvocation i) throws Throwable {
		
		
		// invoke(MethodInvocation i)  -> Advice를 정의하는 곳 = {언제 + 무슨일}을 할지 정의하는 곳
		// 언제 : 메소드 호출 할 때마다 실행
		// 무슨 일 : 횡단 관심사(핵심 공통 분리)에 대한 로직
		
		//핵심 메소드를 실행하면 MyAspect클래스가 실행됨
		
	     System.out.println("method "+i.getMethod()+" is called on "+
	                        i.getThis()+" with args "+i.getArguments()); //MethodInvocation : 가로챈 메소드의 정보
	     
	     Object ret = null;
	     
	    
	     System.out.println("[AOP] 줌인 합니다. 출석 확인.");  //공통코드 Before()
	     try {
	    	 	 ret=i.proceed(); //가로채기해서 핵심코드인 핵심 메소드(classWord())를 실행!!! (XML에서)
			} catch (Exception e) {
				System.out.println("학습 중 오류가 발생했습니다.");
			} finally {
				System.out.println("[AOP] 강의종료 후 퇴실을 확인합니다.");  //공통코드
			}
	     	System.out.println("줌 로그아웃 합니다.");  //공통코드 after()
	     
	     System.out.println("method "+i.getMethod()+" returns "+ret);
	     return ret;
	   }
}
