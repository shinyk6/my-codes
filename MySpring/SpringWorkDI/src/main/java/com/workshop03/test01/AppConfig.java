package com.workshop03.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	
	@Bean
	public MemoryMemberRepository memoryMemberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean
	public FixDiscountPolicy fixDiscountPolicy() {
		return new FixDiscountPolicy();
	}
	
	
	@Bean
	public OrderServiceImpl orderServiceImpl(MemoryMemberRepository memoryMemberRepository, FixDiscountPolicy fixDiscountPolicy) {
		return new OrderServiceImpl(fixDiscountPolicy, memoryMemberRepository);
	}
}
