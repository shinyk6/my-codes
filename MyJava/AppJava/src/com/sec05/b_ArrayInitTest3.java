package com.sec05;

import java.util.Arrays;
//상속구조, 타입으로 선택을 구현하는 switch(Object){} ->객체의 캐스팅
/*switch (expression) {
case Type1 variable -> statement;
case Type2 variable -> statement;
case Type3 variable when condition -> statement;
default -> statement;
}*/


public class b_ArrayInitTest3 {
	public static void main(String[] args) {
		// 각 기본형 타입 배열 선언 및 초기화 (기본값을 확인하기 위해)
		char[] c = new char[2];
		byte[] b = new byte[2];
		boolean[] bool = new boolean[2];
		int[] i = new int[2];
		long[] l = new long[2];
		float[] f = new float[2];
		double[] d = new double[2];
		Object[] o = new Object[2];

		printArray("byte", b);
		printArray("char", c);
		printArray("boolean", bool);   //Boolean[] bool = new ~
		printArray("int", i);
		printArray("long", l);
		printArray("float", f);
		printArray("double", d);
		printArray("object", o);
	}

	public static void printArray(String type, Object array) { //Object array = bool 
											//위 식이 가능한 이유는 Object방을 먼저 생성하고 Boolean만들어서 메모리로딩 됨. bool이 Object주소를 가지고 있어서(시작 주소가 object)
											//상속 관계에 있기 때문에!
		System.out.println("==========================");

		// `switch` 패턴을 활용한 타입 검사 (JDK 21 이상)
		String output = switch (array) { //Object array = bool; -> 
		case boolean[] a -> Arrays.toString(a); //case boolean[] a:   return Arrays.toString(a);  리턴값을 output이 받음
												// bool = array = a -> toString(a)
		case byte[] a -> Arrays.toString(a); // case byte[] a ->  case array : Arrays.toString(a); break; 랑 같은 의미 (해당 타입일 때 오른쪽 명령을 수행)
		case char[] a -> Arrays.toString(a);
		case int[] a -> Arrays.toString(a);
		case long[] a -> Arrays.toString(a);
		case float[] a -> Arrays.toString(a);
		case double[] a -> Arrays.toString(a);
		case Object[] a -> Arrays.toString(a);
		default -> "Unknown Type";
		};

		System.out.println(type + " 배열: " + output);
	}

}
