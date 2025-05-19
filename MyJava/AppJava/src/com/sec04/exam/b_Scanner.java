package com.sec04.exam;
import java.util.Scanner;

/*
 * 
 * 콘솔에서 값 입력 받는 방법
 * 1. java.util.Scanner (클래스) -> 타입의 입력이 메소드로 정해져 있음
 * 2. java.io.BufferedReader   -> 문자열 입력만 특화되어 있음  /예외처리해줘야함
 * 3. java.lang.System.in.read() -> read - 한글자 특화
 * 
 * 
 */

public class b_Scanner {
	
	public static void main(String[] args) {
		/*
	    Scanner sc = new Scanner(System.in); 
	    System.out.print("input i : ");  //println 사용하면 줄바꿔 입력됨.
	    Double i = sc.nextDouble();	//입력 받은 값 scan해서 i에다 넣음 //입력받은 값을 double로 추출해서 넣어줌
		System.out.println("입력받은 값 : "+i );
		sc.close(); //입력 받은 후 닫아주기
		*/
		
		
		//이름, 주소, 전화번호 입력 받아 출력해보자.
		Scanner sc = new Scanner(System.in);         //System.in :표준입력 장치로 스캔하겠다.
		System.out.printf("이름을 입력하세요:");
		String name = sc.nextLine();		//nextLine : 행을 enter로 구분 엔터치면 다음 변수로 넘어감. 그렇기에 공백도 넣을 수 있음
		System.out.printf("주소를 입력하세요:");
		String addr = sc.nextLine();
		System.out.printf("전화번호를 입력하세요:");
		String tel = sc.nextLine();
		
		System.out.printf("%10s %10s %10s \n", name, addr, tel);
		sc.close();

	}

}