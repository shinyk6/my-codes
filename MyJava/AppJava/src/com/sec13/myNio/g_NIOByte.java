package com.sec13.myNio;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class g_NIOByte {
	//byte단위  : Filse.newOutputStream()	Files.newInputStream()
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("a.txt");
		
		//byte A ~ Z 까지 입출력 하자. var = 지역변수 선언, 컴파일 시 타입이 결정남 (람다식에서는 사용X) 이런 상황에서만 사용하는게 좋음.
		try(var out = Files.newOutputStream(path, StandardOpenOption.APPEND)){ //static메소드이기에 new 가 없음 
			for(byte i ='A' ; i<='Z'; i++) {
				out.write(i); // non-static write (리턴받은 객체의 write)
			}
		}

		System.out.println("저장 완료!!");
		
		//데이터 결과 읽기
		System.out.println("데이터 결과 ");
		try(var in = Files.newInputStream(path)){
			int data = 0;
			while( (data = in.read()) != -1 ) {
				System.out.print((char)data);
			}

		}
	}

}
