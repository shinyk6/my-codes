 package com.sec12.mstream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;
import java.nio.file.Path; //파일 경로 하나
import java.nio.file.Paths; //os가 가지는 여러 파일경로

public class FlatMapTest {
	public static void test_flatMap() {
		///flatMap()
			 Path path = Paths.get("D:\\myWork\\MyJava\\AppJava\\src\\com\\sec12\\mstream\\a.txt");
	     try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){ //path: 파일이 있는 경로
	    	 
	    	 //flatMap : 파일의 각 줄을 공백 기준으로 단어를 분철해서 리턴
	    	 //		     Stream<Stream<T>>  같은 여러개의 스트림을 하나의 단일 스트림으로 Flatten할 때 사용함.
	    	 Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" +"))); //1more - 공백 1개 이상
	    	 
	    	 //결과 출력
	    	 words.forEach(System.out::println);
	    	 
	     }catch(IOException e) {
	    	 System.out.println(" 파일이 없어 ");
	     }
	}
	public static void main(String[] args) {
		///flatMap이 아닌 map()으로 해보기
	
		 Path path = Paths.get("D:\\myWork\\MyJava\\AppJava\\src\\com\\sec12\\mstream\\a.txt");
	     try(Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)){ //path: 파일이 있는 경로
	    	 
	    	 //flatMap : 파일의 각 줄을 공백 기준으로 단어를 분철해서 리턴
	    	 //		     Stream<Stream<T>>  같은 여러개의 스트림을 하나의 단일 스트림으로 Flatten할 때 사용함.
	    	 Stream<Stream<String>> words = lines.map(line -> Stream.of(line.split(" +"))); //1more - 공백 1개 이상
	    	 
	    	 //결과 출력 / 중첩 스트림을 처리
	    	 words.forEach(innerStream -> innerStream.forEach(System.out::println)); //forEach안에 또 다른 for를 돌려 다 풀어줘야함
	    	 
	     }catch(IOException e) {
	    	 System.out.println(" 파일이 없어 ");
	     }
	}

}
