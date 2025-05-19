package com.javastudy;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArrTest {

	public static void main(String[] args) {
		
		List<Integer> array = new ArrayList<>();
		ArrayList array2 = new ArrayList<>();
		
		array.add(1);
		array.add(4);
		
		System.out.println("확장 for문 이용한 반복");
		for(int arr : array) {
			System.out.println(arr);
		}
		
		System.out.println("listIterator를 이용한 반복");
		
		ListIterator<Integer> res = array.listIterator();
		while(res.hasNext()) {
		
			System.out.println(res.next());
		}
	}

}
