package com.sec04;

/*switch (expression) {
case pattern1 -> statement;				 		-타입을 지정해서 명령을 수행
case pattern2 when condition -> statement;		-타입을 지정해서 명령을 수행
default -> statement;
}*/

public class PatternSwitchExample {

	public static void main(String[] args) {
			// 1) : break 를 화살표레이블(->)로 대체
			// 2) : 표현식을 간략하게 지정함
			// 3) when문 사용
			// 4) null을 사용할 수 있음
			// 5) 객체타입을 사용해서 case를 만듦 -자식을 호출해서 동적바인딩 할 때 좋음
		        Object obj = 97.1; //가장 큰 데이터타입을 주고 케이스 옆에 타입을 줌
		        switch (obj) {
		        	case Integer i when i > 10 -> System.out.println("10보다 큰 정수: " + i); //화살표레이블 - : , break 없애고 추가됨
		        	case Double d -> System.out.println("실수 : "+d);
		            case Integer i -> System.out.println("정수: " + i);
		            case String s -> System.out.println("문자열: " + s);
		            case null -> System.out.println("Null 값이 입력되었습니다.");
		            default -> System.out.println("기타 값: " + obj);
		        }
		    }
	}




