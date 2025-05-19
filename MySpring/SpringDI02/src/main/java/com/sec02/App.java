package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {

	@Bean
	public HelloMessage helloMessage() {
		return new HelloMessage(); //주입 받은게 없음
	}
	
	@Bean
	public MyMessage mymessage() {
		return new MyMessage();
	}
}
