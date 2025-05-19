package com.sec01.exam;

// 지역 변수는 반드시 선언과 동시에 초기화 해야함
// 정수 100과 200을 a, b라는 이름으로 저장 후 출력 하고 싶다.
public class a_exam {
	//전역변수 영역
	
	public static void main(String[] args) {
	//지역변수 영역	-> 지역변수는 반드시 초기값을 지정한다.
		int a = 0;	// 4바이트 메모리를 a라는 이름으로 만들고 초기값 0을 대입 ->초기화 (4바이트 메모리를 꽉 채움)
		a = 100; //100을 a에 재대입 (덮어쓰기)
	//	2) 3) 4) 1)   수행순서
		System.out.println(a);  //세미콜론을 만나야 명령이 끝남
		
		//초기화 하면서 대입
		int b = 200;
		System.out.println(b);
		
		
	}

}
