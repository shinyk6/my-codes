package com.sec13.myio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// char 단위로 읽고 쓰자.
public class f_MyIO {

	public static void main(String[] args) {
		String filename = "f.txt";
		try {
			MyWrite(filename);
			MyReader(filename);
		}catch(Exception e) {
			System.out.println(e);
		}//try end
		
	}//main end

	private static void MyWrite(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		for(char i = 'A'; i<='Z'; i++) { //한 문자 단위
			fw.write(i); //IOException
		}
		fw.close();
		System.out.println("파일에 A ~ Z 저장했어!! ");
	}
	
	private static void MyReader(String filename) throws IOException {
		FileReader fr = new FileReader(filename);
		int data = 0;
		System.out.println("파일에서 읽은 데이터 ");
		
		while((data=fr.read()) != -1) { //read는 마지막에 도달하면 -1 리턴 //한 바이트씩 읽어서 data에 대입하자 -1이 될때까지
			System.out.print(data+" ");
			System.out.print((char)data+" ");
		}
		
		System.out.println(fr.read());
		fr.close();
	}


}//class end 
