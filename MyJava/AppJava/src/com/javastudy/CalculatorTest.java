package com.javastudy;
import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요");
		
		int score = sc.nextInt();
		
		try {
			ScoreCalculator(score);
		} catch (InvalidScoreException e) {
			
			e.printStackTrace();
		}
	}
	
	static void ScoreCalculator(int score) throws InvalidScoreException{
			if(score<0 || score>100) {
					throw new InvalidScoreException("점수를 다시 입력하세요.");
			}
	}
}


class InvalidScoreException extends Exception{

	public InvalidScoreException(String string) {
		System.err.println("점수를 다시 입력하세요");
	}

}
