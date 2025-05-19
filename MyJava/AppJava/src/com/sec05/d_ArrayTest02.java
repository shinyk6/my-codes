package com.sec05;
//다차원 배열
import java.util.Arrays;

public class d_ArrayTest02 {
	public static void main(String[] args) {
		int ar[][] = new int[][] { { 10, 20, 30 },
			                       { 40, 50, 60 } };

		System.out.println("ar.lenght=" + ar.length);
		System.out.println("ar[0].lenght=" + ar[0].length);
		System.out.println("ar[1].lenght=" + ar[1].length);

		for (int i = 0; i < ar.length; i++) { //아우터 : 행 이너 : 열
			for (int j = 0; j < ar[i].length; j++) {
				System.out.printf("%5d", ar[i][j]);
			}
			System.out.println();
		}
		prn(ar);

	}
	
	//forEach문
	private static void prn(int[][] ar) {
		//간단한 for
		System.out.println("===========================");
		for (int[] i : ar) { //ar  //줄단위
			for (int j : i){  //행단위 리턴
			System.out.printf("%5d", j);
			}
			System.out.println();
		}
		
	}

}
