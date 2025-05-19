package com.sec11.myutil01;

import java.util.*;

public class VectorTest {
	public static void main(String[] args) {

		
		List<String> vector = new Vector<String>(3);

		System.out.println("vector의 크기 : " + vector.size());
		System.out.println("vector의 용량 : " + ((Vector<String>) vector).capacity());

		vector.add("java");
		vector.add("servlet/jsp");
		vector.add("spring");
		vector.add("python");

		System.out.println("데이터 삽입 후 vector의 크기 : " + vector.size());
		System.out.println("데이터 삽입 후 vector의 용량 : " + ((Vector<String>) vector).capacity());

		System.out.println("vector의 첫번째 요소 : " + ((Vector<String>) vector).elementAt(0));

		vector.removeAll(vector);

		System.out.println("데이터 삭제 후 vector의 크기 : " + vector.size());
		System.out.println("데이터 삭제 후 vector의 용량 : " + ((Vector<String>) vector).capacity());

	}
}
