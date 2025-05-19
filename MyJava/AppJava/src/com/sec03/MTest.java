package com.sec03;
//두 개의 정수를 관리하는 클래스
class Test{
	//	int a, b; //앞에 아무것도 명시하지 않으면 default.
	 	//은닉된 멤버 변수
		private int a;
		private int b;
		
		//setter   값을 전달, 변경하겠다. -void 
		public void setA(int a){
			this.a = a; //전달 및 변경	
						//this는 객체 자신을 가리키는 레퍼런스 변수로, 자신의 객체에 접근할 때 사용
						//지역변수 a를 통해서 값을 전달받아 this.a로 대입해서 값 전달 변경
		}
		public void setB(int b){
			this.b = b;
		}
		//getter
		public int getA(){
			return a; //this.a
		}
		public int getB(){
			return b; //this.b
		}
}	
		//=> 외부에서 메소드만 호출 할 수 있음.
		//자바는 기본적으로 모든 멤버 변수는 private, 오픈하고 싶은 것은 상수만.
	

public class MTest {
	
	public static void main(String[] args) {
		//setter, getter는 static이 아니기에 바로 호출 할 수 없으니 객체를 생성해야함
		
		//메모리 할당 객체 생성
		Test m = new Test();
		Test m1 = new Test();
		Test m2 = new Test();
		
		//할당된 주소를 확인
		//각각의 주소 출력 -toString	  //toString은 객체만 있으면 주소를 출력해줌
		System.out.println("각 주소를 출력해보자 " );
		System.out.println(m.toString()+"\t"+m);
		System.out.println(m1.toString()+"\t"+m1);
		System.out.println(m2.toString()+"\t"+m2);		
		

		
		////할당된 초기값을 확인 => 멤버 변수는 객체가 생성될 때 생성자에 의해서 초기값을 대입 후 메모리 할당됨.
		//초기값 호출
		System.out.printf("m a = %5d, b = %5d \n", m.getA(), m.getB());
		System.out.printf("m1 a = %5d, b = %5d \n", m1.getA(), m1.getB());
		System.out.printf("m2 a = %5d, b = %5d \n", m2.getA(), m2.getB());
	}
}
