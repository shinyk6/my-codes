package com.sec07.mytest;

import java.util.Calendar;
import java.util.GregorianCalendar;

//API를 확인 후 상속을 받자. ->GregorianCalendar클래스 상속 받자 (날짜 관리 클래스)
public class MyTest extends GregorianCalendar {
	
	
	
	public MyTest(int i, int j, int k) {
		super(i, j, k); //GregorianCalendar(int year, int month, int dayOfMonth)
						//나는 값이 필요없으니 super 생성자에게 전달
	}

	public MyTest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "내꺼 !!!";
	}

	public static void main(String[] args) {
		MyTest m1 = new MyTest(); //빈방을 만들 수 있는 이유는 기본생성자가 있기 때문
		MyTest m2 = new MyTest(2025, 3, 11);//GregorianCalendar(int year, int month, int dayOfMonth)
		
		System.out.println(m1.toString());     //toString오버라이드 되어있음 (주소 출력X) GregorianCalendar에 toString이 오버라이드 되어 덮어씌어져있어서 그것이 호출된것.
		
		System.out.println(m1.get(Calendar.YEAR)+":"+m1.get(Calendar.MONTH)+":"+m1.get(Calendar.DAY_OF_MONTH));  //get으로 리턴 괄호안-필드값을 넣으면 get으로 리턴
		m1.set(Calendar.YEAR, 2000); //set으로 년도 바꿔보기
		m1.set(Calendar.MONTH, 11);
		System.out.println(m1.get(Calendar.YEAR)+":"+m1.get(Calendar.MONTH)+":"+m1.get(Calendar.DAY_OF_MONTH));

	}

}
