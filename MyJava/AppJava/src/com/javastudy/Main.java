package com.javastudy;

public class Main {

	public static void main(String[] args) {
		
		DeliveryService delivery1 = new StandardDelivery();
		DeliveryService delivery2 = new ExpressDelivery();		
		DeliveryService delivery3 = new InternationalDelivery();
		
		
		delivery1.selectOption("일반");
		delivery2.selectOption("특급");		
		delivery3.selectOption("국제");	
	}

}


class StandardDelivery implements DeliveryService{

	@Override
	public void selectOption(String option) {
	//	if(option=="일반") {  //문자열의 내용을 비교할 땐 ==키워드보다 equals()쓰는게 더 좋음 ==는 객체의 참조를 비교
		if(option.equals("일반")) {
			System.out.println("=== StandardDelivery 테스트 ===");
			System.out.println("일반 배송을 선택합니다.");
			this.trackDelivery();			
		}else {
			return;
		}	
	}

	@Override
	public void trackDelivery() {
		System.out.println("일반 배송 추적을 시작합니다.");
		
	}
}

class ExpressDelivery implements DeliveryService{

	@Override
	public void selectOption(String option) {
		if(option.equals("특급")) {
			System.out.println("=== ExpressDelivery 테스트 ===");
			System.out.println("특급 배송을 선택합니다.");
			this.trackDelivery();	
		}
		
	}

	@Override
	public void trackDelivery() {
		System.out.println("특급 배송 추적을 시작합니다.");
	}
	
}

class InternationalDelivery implements DeliveryService{

	@Override
	public void selectOption(String option) {
		if(option.equals("국제")) {
			System.out.println("=== InternationalDelivery 테스트 ===");
			System.out.println("국제 배송을 선택합니다.");
			this.trackDelivery();	
		}
		
	}

	@Override
	public void trackDelivery() {
		System.out.println("국제 배송 추적을 시작합니다.");	
		
	}
	
}

