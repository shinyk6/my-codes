package com.sec08;




abstract class My{ // new My() 객체 생성 안함 -> 후손인 클래스가 메모리 할당해줘
	public void prn() {
		System.out.println("나 추상의 멤버얌 My's Prn");
	}
	public abstract void disp();// {}가 없고 선언만 되어있는 추상 메소드 (재정의 하라는 뜻)
	
}


class myTest extends My{ //추상 클래스를 상속받은 후손 클래스는 추상클래스의 추상메소드를 반드시 정의해야함
						//만일 재정의 하지 않으면 추상 클래스가 됨 - new객체 생성 불가능
	@Override
	public void disp() {
		System.out.println("그래 난 강제로 정의한 myTest's disp");
	}
}



public class AbsTest {
	public static void main(String[] args) {
		//My = new My(); -> new 객체 생성 불가능
		myTest m = new myTest();//부모인 My(), 자식인 MyTest() 둘 다 메모리에 올림
		m.prn();		//myTest가 메소드를 두 개 가지고 있기에 모두 호출 가능
		m.disp();
		
		//다형성 - 선조가 후손 객체를 참조하여 사용가능
		
		My res = new myTest(); //주소 할당 My(), myTest();  후손이 객체 생성해서 메모리에 올려주었기에 그 후에 선조의 주소번지로 후손 멤버 사용
		res.disp();
		res.prn();
	}

}
