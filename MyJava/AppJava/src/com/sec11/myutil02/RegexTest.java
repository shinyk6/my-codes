package com.sec11.myutil02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	//파일에 있는 국어점수 전체 총점을 구해보자.
	//이름만 추출해서 나열해서 정렬하자
	public static void main(String[] args) {
		String str = new String("jdk7 jdk8 jdk9 jdk10 jdk20 jdk21");
		Pattern pattern1 = Pattern.compile("(jdk\\d)\\s(jdk\\d)\\s(jdk\\d)");
		Matcher matcher1 = pattern1.matcher(str); 
		System.out.println(matcher1.matches());//해당패턴이 맞는지 안맞는지 확인 (matcher)
		System.out.println("---------------" + "\n");

		Pattern pattern2 = Pattern.compile("\\s");
		String[] splitStr = pattern2.split(str);
		for (int i = 0; i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
		System.out.println("---------------" + "\n");

	}

}
