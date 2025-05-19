package com.test;


abstract class ABC{
	
	public abstract void prn();
	public abstract void disp();
}


class XX extends ABC{ //재정의하거나 추상이 되거나

	@Override
	public void prn() {
		// TODO Auto-generated method stub
		System.out.println("XX'prn");
		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("XX'disp");		
	} 
}

class YY extends ABC{

	@Override
	public void prn() {
		// TODO Auto-generated method stub
		System.out.println("YY'prn");		
	}

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		System.out.println("YY'disp");			
	}
	
	
}

public class MTest {
	
	//메소드를 만들어서 가져다 쓰는것이 훨씬 좋음!
	public static void view(ABC obj) { //가장 큰 선조 타입을 넣기
		//클래스
		//swtich case문으로 타입확인 (후손객체확인)
		// -> 는 : , return 을 합쳐놓은 것
		switch(obj) {
		case XX xx->{	//:과 return을 합친것 ->
						xx.disp();      //XX일때는 disp, prn호출하고 종료함
						xx.prn();
					}
		case YY yy->{
						yy.prn();		//YY일때 prn, disp호출하고 종료함
						yy.disp();
					}
		default -> System.out.println("알 수 없는 타입이야."); //그 외에 경우
		}
		
		//obj.disp();
		//obj.prn();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			ABC a1 = new XX();		//객체 생성하는 4가지 방법 (다운캐스팅)	//선조의 주소번지로 내가 원하는 후손의 객체를 생성해서 재정의한 메소드를 호출함 동적바인딩
			ABC a2 = new YY();		
			
			view(a1);
			view(a2);
//			XX x1 = new XX(); //이렇게 되면 메모리에 엄청나게 올라감->동적바인딩이 필요
//			YY y1 = new YY();
	}

}
