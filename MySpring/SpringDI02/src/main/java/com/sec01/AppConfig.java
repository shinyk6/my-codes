package com.sec01;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



//XML대신 class로 환경설정하기

@Configuration //xml처럼 사용 (환경설정하는 클래스)
public class AppConfig {
	
//	<bean id="myaddress" class="com.sec01.MyAddress">
//	<constructor-arg value="정길동" type="java.lang.String"/>
//	</bean>
	
	@Bean //bean태그 대신 Bean어노테이션으로 객체 생성
	public MyAddress myaddress() { //bean id를 메소드명으로 지정
		return new MyAddress("박길동");
	}
	
	
	@Bean
	public MyAddress myaddress02() {
		return new MyAddress("정길동", "제주도"); //생성자 주입
	}
	
	@Bean
	public MyAddress myaddress03() {
		return new MyAddress("최길동", "부산", "00-000-0000");
	}
	
	
	@Bean
	public AddressInfo info() {
		AddressInfo info = new AddressInfo();
		info.setAddress(myaddress03()); //의존성 주입
		info.setAge(100);
		return info;
	}
}
