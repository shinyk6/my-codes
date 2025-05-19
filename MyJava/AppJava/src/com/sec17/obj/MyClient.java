package com.sec17.obj;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	
	public static void main(String[] args) {
		try(
		Socket sc = new Socket("localhost",7777);
		ObjectOutputStream oos = new ObjectOutputStream(sc.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(sc.getInputStream());
		
		/// 클라이언트에서 값 입력
		Scanner sc_input = new Scanner(System.in)){
		System.out.printf("첫번째 숫자 : ");
		double a = sc_input.nextDouble();
		System.out.printf("연산자 : ");
		String op = sc_input.next();
		System.out.printf("두번째 숫자 : ");
		double b = sc_input.nextDouble();
		
		// 객체 담고 서버로 보냄 : SendData 객체에 담은 후 oos에 담아서 서버로 전송
		SendData sd = new SendData(a, b, op);
		oos.writeObject(sd); // getOutputStream
		oos.flush();
		
		// 서버로부터 리턴받은 결과값 출력 : ois가 서버가 준 값을 가지고 있음
		SendData response = (SendData)ois.readObject();
		System.out.println("서버로부터 받은 연산 결과 : "+response.getResult());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//main
}//class
