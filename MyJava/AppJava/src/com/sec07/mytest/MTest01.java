package com.sec07.mytest;

// 클래스간의 객체 캐스팅을 통해 동적바인딩의 개념을 이해할 수 있다.
public class MTest01 {

	public static void main(String[] args) {
		//객체를 초기값으로 생성해놓고 setter로 값을 전달 및 변경 후 결과를 리턴
		DD d1 = new DD(); // (a+b)-c*d = 
		System.out.println("초기값 확인 : " + d1.getRes());
		prn(d1);
		BB b1 = new BB();
		prn02(b1); //에러뜸 -> DD를 가지고 있지 않기에
		//객체를 생성할 때 초기값 전달 후 연산 결과 리턴
		
	}
	
	public static void prn(DD res) { //정적 바인딩
		//값 전달 및 변경
		res.setA(100);
		res.setB(20);
		res.setC(1);
		res.setD(1);
		System.out.println(res.getRes());
	}
	
	public static void prn02(AA res) { //동적 바인딩 : 생성된 객체 주소를 선조의 객체가 참조해서 후손을 필요에 따라 찾아가는 것
		//값 전달 및 변경
		res.setA(100);
		res.setB(20);
		((BB) res).setC(1);
		((DD)res).setD(1);
		System.out.println(((DD)res).getRes());
	}
	

}
