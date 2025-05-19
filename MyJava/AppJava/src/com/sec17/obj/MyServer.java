package com.sec17.obj;

import java.net.*;
import java.io.*;

//blocking
public class MyServer {
	public static void main(String[] args) {
		
		
		try(ServerSocket server = new ServerSocket(7777)){
		System.out.println("서버 대기중......");
		
			while(true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속");
				
				try(ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
					ObjectInputStream ois = new ObjectInputStream(client.getInputStream())){
				
					SendData response = (SendData) ois.readObject(); //클라이언트가 보낸 값 
					double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOp());
					response.setResult(res); // 계산된 결과 리턴
					
					//클라이언트로 계산된 결과 보내자
					oos.writeObject(response); //이때 클라이언트가 readObject실행
					oos.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}//while
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}

	
	
	private static double MyCalculate(double a, double b, String op) {
		
		return switch(op) {
		case "+" -> a+b;
		case "-" -> a-b;
		case "*" -> a*b;
		case "/" -> b!=0?a/b:Double.NaN; //삼항연산자
		default -> 0;
		};
	}

}
