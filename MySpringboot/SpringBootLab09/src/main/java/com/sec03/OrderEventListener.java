package com.sec03;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component 
public class OrderEventListener {
	
	@Order(1) //우선순위 1번 - 두개가 동시에 들어오면 이것부터 실행
	@EventListener(condition = "#event.productName.equals('Mackbook')") 
	public void handleMacBook(OrderCreatedEvent event) { 
		//기타 코드 작성
		System.out.println("[1] MacBook 주문 알림 전송 : " + event.getProductName()); 
	} 
	
	
	@Order(2) //순위 2번
	@EventListener(condition = "#event.productName.equals('keyboard')")
	public void handleKeyboard(OrderCreatedEvent event) { 
		//기타 코드 작성
		System.out.println("[2] Keyboard 주문 알림 전송 : " + event.getProductName()); 
	} 
	
	@Order(3)
	@EventListener(condition = "#event.productName.equals('notebook')")
	public void handleNotebook(OrderCreatedEvent event) { 
		System.out.println("[3] noteBook 주문 알림 전송 : " + event.getProductName()); 
	} 
	
	@Order(4) 
	@EventListener(condition = "#event.email.endsWith('.com')") 
	public void handleComUser(OrderCreatedEvent event) { 
		System.out.println("[4] com 도메인 가입자 : " + event.getEmail()); 
	} 
	
	@Order(5)
	@EventListener(condition = "#event.email.endsWith('.co.kr')") 
	public void handleCoKrUser(OrderCreatedEvent event) { 
		System.out.println("[5] co.kr 도메인 가입자 : " + event.getEmail()); 
	} 
}
