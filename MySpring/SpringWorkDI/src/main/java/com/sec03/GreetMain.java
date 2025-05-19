package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

	public static void main(String[] args) { 
		//싱글톤 - 같은 id bean을 여러번 호출 (컨테이너 하나 당 하나의 인스턴스) 동일 객체 공유 ->생성과 소멸 관리
		//프로토타입 - getBean()으로 하나의 id를 여러개의 새로운 객체로 생성 -> 요청할 때마다 새로 생성 ->생성만 관리
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1-03.xml");
		GreetService res = context.getBean("greetService", GreetService.class);
		GreetService res02 = context.getBean("greetService", GreetService.class);
		//res.sayHello();
		
		///1. 객체 참조가 동일한지 확인
		System.out.println(res);
		System.out.println(res02);
		
		///2. 주소로 확인
		System.out.println(res == res02);
		
		///3. 해쉬코드로 확인
		System.out.println(System.identityHashCode(res)); //해시코드 값
		System.out.println(System.identityHashCode(res02));  // 해시코드 값 - 객체 참조 동일한지 확인
	}

}
