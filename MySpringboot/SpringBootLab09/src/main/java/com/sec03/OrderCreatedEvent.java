package com.sec03;

public class OrderCreatedEvent {  // 단순 POJO 사용 권장
	
	private final String productName;
	private final String email;
	
	public OrderCreatedEvent(String productName, String email) {
		this.productName = productName;
		this.email = email;
	}

	public String getProductName() {
		return productName;
	} 
	
	public String getEmail() {
		return email;
	} 
} 