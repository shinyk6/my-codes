package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1-01.xml");
		
		//MorningGreet res = context.getBean("morningGreet", MorningGreet.class );
		
		//구체 클래스를 bean으로 등록하고, getBean()을 사용해서 선조인 인터페이스로 리턴한다. 
		
		///1. 메모리 로드 된 객체를 찾아서 리턴 확인
		Greet greet = ctx.getBean("morningGreet", Greet.class);
		System.out.println(greet.greeting());
		
		///2. 현재 메인영역에서 작업하는 ctx확인
		System.out.println("== main ==");
		System.out.println(ctx.toString());
		System.out.println(ctx.getDisplayName()); //이름 출력
		
		///3. ctx를 소멸 시킴 (CG로 보냄)
		((AbstractApplicationContext) ctx).close();  // 서브인터페이스의 메소드라서 다운캐스팅(형변환)
		 											 // ctx를 자동 close
		
		System.out.println("== end main ==");
		System.out.println(ctx.toString());
		System.out.println(ctx.getDisplayName());
		
	
		/*	
		if(ctx instanceof ConfigurableApplicationContext) { //ctx를 명시 close
			((ConfigurableApplicationContext) ctx).close();
		}
		 */	
		
		///4. ctx가 close가 됐는지 확인
		if(ctx instanceof ConfigurableApplicationContext) {
			boolean isActive = ((ConfigurableApplicationContext) ctx).isActive();
			System.out.println(isActive); //close하여 false출력됨
		}
		
		///5. close가 되었는데, getBean()으로 재확인
		try {
			greet = ctx.getBean("morningGreet", Greet.class);
			System.out.println(greet.greeting());
		}catch(IllegalStateException i){
			System.out.println("BeanFactory not initalized or already closed");
		}


	}

}
