package com.sec13.myNio;
import java.nio.file.*;

// D: Test 
// 		-AA
//		-BB
//		  -a.txt 파일을 생성해보자.
public class a_NIO2 {

	public static void main(String[] args) throws Exception{
			
		//Q1. D: Test 폴더 생성하자.
		
		//경로는 path로 가지고 옴
		Path test = Paths.get("D:\\test");
		
		//조작은 Files로 함
		//Files.createDirectory(test); 
		
		//Q2. test\\AA 폴더 생성 (하위 폴더생성)
		Path aadir = test.resolve("AA"); //테스트가 가지고 있는 하위경로에 AA폴더 생성하겠다.
		//Files.createDirectories(aadir); //이렇게되면 D폴더와 그 속 AA폴더가 같이 생성됨 //이미 D폴더가 존재하기에 Exception
		
		//Q3. test\\BB 폴더 생성 (하위 폴더생성)
		Path bbdir = test.resolve("BB"); //테스트가 가지고 있는 하위경로 패스
		//Files.createDirectories(bbdir);		
		
		//Q4. test\\BB\\a.txt 파일 생성 (하위 폴더생성)
		Path atxt = bbdir.resolve("a.txt"); //테스트가 가지고 있는 하위경로 패스
		//Files.createFile(atxt);       //파일 생성은 createFile()사용
		
		System.out.println("다 만들었어");
		
		//Q5. test\\BB\\a.txt 만 삭제해보자
		Files.delete(atxt);
		
		System.out.println("삭제 했어");
		
	}

}
