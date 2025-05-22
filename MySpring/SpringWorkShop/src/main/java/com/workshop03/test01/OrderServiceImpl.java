package com.workshop03.test01;

//생성자 주입 클래스
public class OrderServiceImpl implements OrderService {
	
	private DiscoundPolicy discountPolicy;
	private MemberRepository memberRepository;
	
	
	
	
	
	public OrderServiceImpl(DiscoundPolicy discountPolicy, MemberRepository memberRepository) {
		this.discountPolicy = discountPolicy;
		this.memberRepository = memberRepository;
	}





	// 구현 클래스 (회원id와 가격을 받아 할인 처리 후 주문 정보 문자열리턴)
	@Override
	public String order(int id, int price) {

		String member;
		int discount;
		int money;
		member = memberRepository.findMemberById(id);
		discount = discountPolicy.getDiscoundAmount(price);
		money = price-discount;
		
		return "회원: "+member+"\n주문 금액: "+price+" 원 \n할인 금액: "+discount+" 원 \n최종 결제 금액: "+money+" 원";
	}

}
