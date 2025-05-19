package com.sec01.exam;

/*
 * 
 * 표준 출력장치 - 모니터
 * 표준 입력장치 - 키보드
 * 
 * 표준 출력
 * 	1. Java.lang.System.out.print()  //줄바꿈 없이 출력
 * 	2. Java.lang.System.out.prinln()  //줄바꿈 포함 출력
 * 	3. Java.lang.System.printf()  //formatString 
 * 		->
 *			PrintStream java.io.PrintStream.printf (String format, Object... args) //매개인자가 2개  ... : 자바에서 1more
 * 
 * 
 */
public class h_exam {

	public static void main(String[] args) {
		// %d: 정수 (decimal integer)
		System.out.printf("[%%d:] ->  %d\n", 100); // 100  \n : 줄바꿈
		System.out.printf("[%%d:] ->  %5d %d\n", 100, 200); // 100 
		System.out.printf("[%%d:] ->  %5d -%5d\n", -100, 200); // 100  -를 %밖에 쓰면 -라는 문자열을 출력.
		System.out.printf("[%%d:] ->  %5d %-5d\n", -100, 200); // 100  -를 %안에 쓰면 전체 5자리에서 왼쪽에 딱 붙인다는 의미 (자릿수를 지정)
		// %f: 실수 (floating-point number)
		System.out.printf("%%f: %.2f\n", 3.14159); // 3.14    //소수 이하 2자리 출력

		// %c: 문자 (character)
		System.out.printf("%%c: %c\n", 'A'); // A

		// %s: 문자열 (string)
		System.out.printf("%%s: %s\n", "Hello"); // Hello

		// %x, %X: 16진수 (hexadecimal)
		System.out.printf("%%x: %x\n", 255); // ff         //대소문자 구분x
		System.out.printf("%%X: %X\n", 255); // FF

		// %o: 8진수 (octal)
		System.out.printf("%%o: %o\n", 8); // 10

		// %b: 논리값 (boolean)
		System.out.printf("%%b: %b\n", true); // true
	}

}
