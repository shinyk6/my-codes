package com.sec11.myutil02;

import java.util.StringTokenizer;

/*
 * 
 * 문자열 추출해서 <find 할 경우> 문자열단위로 자르기 찾기 변환
 * 1. Scanner
 * 2. java.util.regx 
 * 3. String
 * 4. StringTokenizer
 * 
 */
public class StringTokenizerTest {
	public static void main(String[] args) {
		String str = "java,jdbc,servlet/jsp,spring/JDBCTemplate";
		StringTokenizer st = new StringTokenizer(str, ",/");
		while (st.hasMoreTokens()) // - / 잘라내고 토큰단위로 관리
			System.out.println(st.nextToken());
	}

}