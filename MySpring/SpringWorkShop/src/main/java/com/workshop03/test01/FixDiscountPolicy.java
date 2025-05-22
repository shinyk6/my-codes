package com.workshop03.test01;

public class FixDiscountPolicy implements DiscoundPolicy {

	@Override
	public int getDiscoundAmount(int price) { // 고정 금액 할인 제공
		return price/10;
	}


	

}
