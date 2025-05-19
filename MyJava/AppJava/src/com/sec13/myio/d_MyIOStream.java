package com.sec13.myio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// byte(스트림) 단위로 읽고 쓰자.
public class d_MyIOStream {

	public static void main(String[] args) {
		String filename = "d.txt";//파일의 정보는X 
		//File filename = new File("/AppJava/src/com/sec13/myio"); //원하는 패스 지정
		//파일의 객체를 만들면 정보도 리턴 받을 수 있음
		//System.out.println(filename.getPath());
		//System.out.println(filename.getAbsolutePath()); //파일의 경로를 가져옴
		
		try {
			MyWrite(filename);
			MyReader(filename);
		}catch(Exception e) {
			System.out.println(e);
		}//try end
		
	}//main end

	private static void MyWrite(String filename) throws IOException {
		FileOutputStream fo = new FileOutputStream(filename);
		for(byte i = 'A'; i<='Z'; i++) {
			fo.write(i); //IOException
		}
		fo.close();
		System.out.println("파일에 A ~ Z 저장했어!! ");
	}
	
	private static void MyReader(String filename) throws IOException {
		FileInputStream fi = new FileInputStream(filename);
		int data = 0;
		System.out.println("파일에서 읽은 데이터 ");
		
		while((data=fi.read()) != -1) { //read는 마지막에 도달하면 -1 리턴 //한 바이트씩 읽어서 data에 대입하자 -1이 될때까지
			System.out.print(data+" ");
			System.out.println((char)data+" ");
		}
		
		System.out.println(fi.read());
		fi.close();
	}


}//class end 
