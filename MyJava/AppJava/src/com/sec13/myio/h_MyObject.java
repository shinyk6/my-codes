package com.sec13.myio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

// Object 단위로 읽고 쓰자.
public class h_MyObject {

	public static void main(String[] args) {
		String filename = "h.txt";
		
		try {
			MyWrite(filename);
			MyReader(filename);
		}catch(Exception e) {
			System.out.println(e);
		}//try end
		
	}//main end

	private static void MyWrite(String filename) throws IOException {
		ObjectOutputStream bo = new ObjectOutputStream(new FileOutputStream(filename));
		for(byte i = 'A'; i<='Z'; i++) {
			bo.writeByte(i); //IOException
		}
		bo.close();
		System.out.println("파일에 A ~ Z 저장했어!! ");
	}
	
	private static void MyReader(String filename) throws IOException {
		ObjectInputStream bi = new ObjectInputStream(new FileInputStream(filename));
		int data = 0;
		System.out.println("파일에서 읽은 데이터 ");
		
		while((data=bi.readByte()) != -1) { //한 바이트씩 읽어서 data에 대입하자 -1이 될때까지 
											//writeByte를 사용했으니 readByte로 바꿔주기
			System.out.print(data+" ");
			System.out.println((char)data+" ");
		}
		
		System.out.println(bi.read());
		bi.close();
	}


}//class end 
