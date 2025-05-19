package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class g_MyIO {

	public static void main(String[] args) {
		String filename = "g.txt";
		
		try {
			//MyWrite(filename);
			MyReader02(filename);
		}catch(Exception e) {
			System.out.println(e);
		}//try end
		
	}//main end

	private static void MyWrite(String filename) throws IOException {
		
		BufferedWriter bo = new BufferedWriter(new FileWriter(filename));
		for(char i = 'A'; i<='Z'; i++) {
			bo.append(i); //IOException
		}
		bo.close();
		System.out.println("파일에 A ~ Z 저장했어!! ");
	}
	
	private static void MyReader02(String filename) throws IOException {
		//라인 단위로 읽겠다 = String
		
		BufferedReader bi = new BufferedReader(new FileReader(filename));
		String data = null; //한줄씩 읽어서 대입할 객체 변수 null로 지역변수 초기화
		System.out.println("파일에서 읽은 데이터 ");
		
		while((data=bi.readLine()) != null) { // 0~65535코드 값으로 data에 대입하자 -1될 때까지
			System.out.print(data);		
		}
		
		System.out.println(bi.read());
		bi.close();
	}


}//class end 
