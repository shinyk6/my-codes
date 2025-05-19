package com.sec01.exam;

//shift + ctrl + f ->자동정렬
public class i_exam {

	public static int getA() { // int값을 리턴함
		return 100; // 리턴값이 있기에 데이터타입은 getB메소드는 int
	}

	public static char getCh() {
		return 'A';
	}

	public static double getDouble() {
		return 98.1;
	}

	public static void main(String[] args) {

		// int a = 100;
		// System.out.println("a=" + a); //a를 부르면 값을 리턴

		int a = getA(); // 메소드를 호출
						// getB()라고 하는 static메소드는 100을 리턴
						// 방을 만든 후 리턴
		System.out.println("a=" + a);
		System.out.println("a=" + getA()); // 방을 만들지 않고 리턴    //static메소드는 클래스명없이 바로 호출 가능

		/// 'A'
		System.out.println(getCh()); // public static char getCh(){return 'A';}

		/// 98.1
		System.out.println(getDouble()); // public static double getDouble(){return 98.1}

	}

}
