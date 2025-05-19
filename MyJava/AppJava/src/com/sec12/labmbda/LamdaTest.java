package com.sec12.labmbda;

public class LamdaTest {
	
	@FunctionalInterface	//함수형 인터페이스 인지 체크 협업할때는 반드시 명시
	interface Fun01{
		public String prn(String name); //매개인자 메소드
	}

	interface Fun02{
		public String prn02(); //매개인자없는 메소드
	}
	
	@FunctionalInterface	
	interface Fun03{
		public void say(String name); //문자열을 받아서 출력하는 메소드
	}
	
	

	public static void main(String[] args) {
		Fun01 m_name = name -> "hello!!" + name; //(name)을 ()를 생략가능 -> :리턴키워드 포함
												//매개인자 -> 명령 형식
												
		System.out.println("m_name : " + m_name.prn("홍길동"));
		
		Fun02 m_test = () -> "테스트"; // {}와 return키워드 생략 return "테스트";
		System.out.println(m_test.prn02());
		
		Fun03 m_test03 = (name) -> System.out.println("hello"+name); 
		m_test03.say("정길동");
	}

}
