package com.sec04;
import java.util.Scanner;

//case 값; 으로 이동해서 break를 만날때까지 순차적으로 명령을 실행함.
public class SwitchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("원하는 달을 입력하세요 : ");
		month = sc.nextInt(); //char,short, int, String 자동으로 형변환 해줌

		switch (month) { //int month = 2;
		case 9:
		case 10: 
		case 11:	
		case 12:
			System.out.println("겨울"); break;
			         //break;
		case 3:
		case 4:
		case 5:  System.out.println("봄"); break;
			        // break;
		case 1:
		case 2:	 System.out.println("겨울"); break;
		
		case 6:
		case 7:
		case 8:     System.out.println("여름"); break;
			          //   break;
			        //   break;
		default:
			System.out.println("원하는 달이 없습니다");
		}//switch end
	}//main end
}//SwitchTest end


