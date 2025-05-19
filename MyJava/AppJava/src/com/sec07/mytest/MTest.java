package com.sec07.mytest;

//생성자 확인 
public class MTest {

	public static void main(String[] args) {
		//new AA(); //단일 클래스 호출 
		// DD(); // AA() BB()

		AA a1 = new DD(); //AA(), BB(), DD()   
		//a1는 하나짜리만 받지만 시작주소만 알면 , new DD()로 인해 메모리에 올라가있는 상태인 AA,BB,DD객체를
		//다운캐스팅해서 찾아갈 수 있음 
						//=연산자가 되는 이유는 ?
		BB b1 = new DD(); // AA(), BB(), DD)
		BB b2 = new BB(); // AA(), BB() 
		AA c1 = new BB(); // AA(), BB()
		//BB b3 = new AA();    //불가능
		//메모리에 할당 됐는지 보고, 몇개를 참조한 시작주소인지를 확인하여 참조해야함
		//오른쪽이 더 커야함
		
		System.out.println("===========================");
		check_instance(b2); 
		//instanceof -> 하위클래스부터 검사해서 객체 타입을 확인함.
		
	}
	

	public static void check_instance(AA obj) {
		if(obj instanceof DD) {
			System.out.println("객체는 DD클래스의 인스턴스이다.");
		}else if(obj instanceof BB){
			System.out.println("객체는 BB클래스의 인스턴스이다.");
		}else {
			System.out.println("객체는 AA클래스의 인스턴스이다.");
		}
	}

}
