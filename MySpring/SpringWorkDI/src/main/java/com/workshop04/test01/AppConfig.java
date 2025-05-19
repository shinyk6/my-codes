package com.workshop04.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.workshop04.test01") //해당 패키지 내 모든 빈 관련 어노테이션 스캔
public class AppConfig {

	@Bean
	public Student student() {
		return new Student();
	}
}
