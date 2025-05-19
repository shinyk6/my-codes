package com.sec13.myNio;

import java.nio.ByteBuffer;

public class i_BufferedTest {

	public static void main(String[] args) {
		System.out.println("=====ByteBuffer 확인=====");
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		
		byteBuffer.put((byte) 'A');
		byteBuffer.put((byte) 'B');
		
		byteBuffer.mark();//mark 저장 position = 1 책갈피 [0]A [1]B [2]C [3]D
		
		byteBuffer.put((byte) 'C');
		byteBuffer.put((byte) 'D');		
		System.out.println("데이터 저장 후 before reset: " + byteBuffer.position() + " " + byteBuffer.limit());
		
		byteBuffer.reset(); // mark 위치로 돌아감 
		byteBuffer.put((byte) 'E');//덮어쓰기 	
		System.out.println("읽기");
		byteBuffer.flip(); // 읽기 상태로 전환 //limit - 3이 됨
		
		System.out.println("flip 이후 :  after reset: "  + byteBuffer.position() + " " + byteBuffer.limit());
		while(byteBuffer.hasRemaining()) {
			System.out.println((char)byteBuffer.get());
		}
		
	}

}
