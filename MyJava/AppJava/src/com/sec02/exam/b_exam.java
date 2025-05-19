package com.sec02.exam;

public class b_exam { 
	//인스턴스 객체 생성해서 주소로 찾아오라는 것. non-static (Instance Method)
	public void prn() { 
		System.out.println("b_exam'prn -> non-static"); //b_exam'prn : b_exam의 메소드
	}

	public static void main(String[] args) { 
			b_exam m = new b_exam(); 	//데이터타입을 모르기때문에 자유영역공간에(static 영역) m이란 메모리방을 추가
										//static메소드 - 주소가 바인드 되어있음 //이 주소를 Object의 toString이 가지고 있음
										//com.sec02.exam.b_exam@2ff4acd0 
										//new연산자를 만나면 객체를 자유영역 공간에 동적 할당하고[=클래스 객체를 생성한다.] 실행이 끝나면 소거함
										//b_exam() : 생성자
										
			
			System.out.println(m.toString()); //동적메모리를 할당한 주소가 리턴됨 (@뒤는 주소)
												//toString이 주소를 문자열로 변환해서 return해줌
			System.out.println(m);
			m.prn(); //toString이 가진 m의 주소로 가서 prn()을 호출
			
			
			b_exam m2 = new b_exam(); 
			System.out.println(m2.toString()); //m1와 방이 다르기에 주소가 다름
			System.out.println(m2);
			m2.prn();
	}
}
