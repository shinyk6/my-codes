package com.javastudy;

public class array {

	public static void main(String[] args) {
		
		int arr[] = {10,20,30,40,50};
		System.out.println(arr.length);
		
		for(int i=0; i<=arr.length-1; i++) {
			System.out.println("배열의 값 출력 = " + arr[i]);
		}
		
		//foreach문
		for(int res:arr) {
			System.out.println(res);
		}
		
		

	}

}
