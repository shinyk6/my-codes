package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext04.xml");
        
        // 정확한 패키지의 GreetService로 타입 맞추기
        GreetService res = context.getBean("greetService", GreetService.class);
        res.sayHello(); // 출력: 편안한 저녁입니다.
    }
}
