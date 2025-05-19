package com.sec04.exam;

public class d_ifTest {
	
	// 1. 여러 조건을 조합한 경우
	public static void checkPassOrFail(int score, boolean isPassed) {
		
		//만약 score가 80이상이고 isPassed true 이고 sore가 홀수인경우
		if (score >= 80 && isPassed && score % 2 != 0) {
			System.out.println("우수한 성적으로 합격했습니다.");
		} else {
			System.out.println("조건을 충족하지 못했습니다.");
		}
	}

	// 2. 범위와 논리 연산자를 조합한 경우
	public static void checkEligibility(int age, String country) {
		
		//age가 18세 이상 30세 이하이거나 korea이 경우 조건을 충족한다라고 출력하자.
		if ((age >= 18 && age <= 30) || country.equals("Korea")) { //> .equls()객체의 값을 비교하는 Ojbect재정의 메소드 (Objectclass)
																	//가지고 있는 현재값과 그 다음 넘겨받은 값을 비교
			System.out.println("조건을 충족합니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	// 3. 객체 유형과 조건을 조합한 경우
	public static void checkStringLength(Object obj) {//모든 클래스의 가장 최상위 클래스.  상위 부모타입을 선언하게 되면 모든 Class는 대입됨
		if (obj instanceof String && ((String) obj).length() > 5) {   //가장 큰 것의 String을 주면 자동캐스팅.
				//instanceof : 객체 타입을 확인하는 연산자. //obj가 String클래스의 인스턴스이고, 문자열의 길이가 5보다 큰 경우만 메세지 출력하자.
				//String -> Object -> (String) obj      (String)obj 자체가 String클래스임.
				
			System.out.println("길이가 5보다 큰 문자열입니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	// 4. 삼항 연산자와 조합한 경우
	public static void checkEvenPositive(int num) {
		//삼항 연산자는 조건식? true명령 : false명령;  
		//num이 배수면 true, 그렇지 않으면 false를 isEven에 대입하자.
		
		boolean isEven = (num % 2 == 0) ? true : false; //2로 나누어 떨어지면 2의배수.
		
		//num이 0보다 크면 양수를 result에 대입, 그렇지 않으면 "음수 또는 0"를 대입하자.
		String result = (num > 0) ? "양수" : "음수 또는 0";
		
		
		if (isEven && result.equals("양수")) {
			System.out.println("짝수 양수입니다.");
		} else {
			System.out.println("조건을 충족하지 않습니다.");
		}
	}

	public static void main(String[] args) { 
		// 1. 여러 조건을 조합한 경우
		checkPassOrFail(85, true);
		checkPassOrFail(75, false);

		// 2. 범위와 논리 연산자를 조합한 경우
		checkEligibility(25, "USA");
		checkEligibility(35, "Korea");
		checkEligibility(17, "Japan");

		// 3. 객체 유형과 조건을 조합한 경우
		checkStringLength("HelloWorld");
		checkStringLength(123);

		// 4. 삼항 연산자와 조합한 경우
		checkEvenPositive(10);
		checkEvenPositive(-5);
	}

}
