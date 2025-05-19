package com.sec07.mytest03;

public class MOX {
	public static void main(String[] args) {
		ScoreOX p[] = { new ScoreOX(1, "루리", new int[] { 1, 2, 1, 3, 4 }), //객체 배열 생성자
				new ScoreOX(2, "루세", new int[] { 1, 1, 1, 1, 1 }),
				new ScoreOX(3, "루오", new int[] { 1, 2, 1, 3, 1 }),
				new ScoreOX(4, "폴리", new int[] { 1, 1, 1, 3, 1 }),
				new ScoreOX(5, "밀로", new int[] { 1, 4, 2, 5, 4 }) };

		for (int i = 0; i < 5; i++) {
			p[i].compute(); // non-static
		}
		ScoreOX.Ranking(p); // 공용메소드 static 클래스명.메소드

		System.out.println(" * * 시험결과 * * \n");
		System.out.println("------------------------------------------");
		System.out.println("번호  이름   1   2   3   4   5      점수   등수 ");
		System.out.println("------------------------------------------");

		for (int i = 0; i < 5; i++)
			p[i].display(); // non-static
		System.out.println("\n 전체맞은 개수  = " + ScoreOX.tot); //공용변수 - 누적변수는 static으로 구현 클래스명.변수

	}
}


