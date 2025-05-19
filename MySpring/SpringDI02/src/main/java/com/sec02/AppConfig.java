package com.sec02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

@Configuration
@Import(App.class)
public class AppConfig {
	
	@Bean({"AA", "BB", "DD"})
	@Lazy
	public MessagePrinter messagePrint(HelloMessage helloMessage) { //생성자에 주입하기 위해 매개변수로 받음
		return new MessagePrinter(helloMessage); //생성자 주입
	}
	 
	@Bean
	public MessagePrinter messagePrint02(MyMessage mymessage) {
		return new MessagePrinter(mymessage);
	}
	
	@Bean
	public Integer myResource02() {
		return new Integer("100"); // return 100;  -> 자동 형변환
	}
 
}
