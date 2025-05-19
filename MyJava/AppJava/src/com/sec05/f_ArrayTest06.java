package com.sec05;


//가변 배열 : 배열을 선언할 때 행을 선언하고 열은 생성되는 값에 의해 정해지는 형태 (첫번째 주소번지를 정해놔야하기 때문에 행 선언)
public class f_ArrayTest06 {
	public static void main(String[] args) {
		int[][] myArrays = new int[3][]; // 2차원 행을 명시         //먼저선언 - 타입,개수를 명시하지 않아서 
		myArrays[0] = new int[] { 1, 2, 3 };  // -> 방 3개 만듦 
		myArrays[1] = new int[] { 5, 4, 3, 2, 1 }; //1번지는 5개를 참조
		myArrays[2] = new int[] { 11, 22 }; 
		
		System.out.println(myArrays [0][2]);
		for (int i = 0; i < myArrays.length; i++) {
			for (int j = 0; j < myArrays[i].length; j++) {
				System.out.printf("%5d", myArrays[i][j]);
			}
			System.out.println();
		}
	}
}
