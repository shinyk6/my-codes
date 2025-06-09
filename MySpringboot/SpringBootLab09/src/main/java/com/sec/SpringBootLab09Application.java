package com.sec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sec01", "com.sec02", "com.sec03"}) //SpringBootLab09Application이 실행하는 패키지보다 상위에 있어야하는데, 동일 패키지에 있기에 @ComponentScan 사용
public class SpringBootLab09Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLab09Application.class, args);
	}

}
