package com.sec17.obj;

import java.net.*;
import java.util.concurrent.*;
import java.io.*;

// virtual로 바꾸기 (non-blocking)
public class MyServerVirtual {
	public static void main(String[] args) {
		
		try(ServerSocket server = new ServerSocket(7777);
			ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor() 
			){
			System.out.println("서버 대기중......");
		
			while(true) {
				Socket client = server.accept();
				System.out.println("클라이언트 접속");
				executor.submit(()->handleClient(client)); //스레드를 구현하는 일을 핸들러함
			}//while
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void handleClient(Socket client) {
		//Socket sm = client;
		//매개인자로 받을 때 위 코드 대신 try안에 명시적으로 선언 - 작업이 끝나면 null로 초기화 해줌
		try(client; ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream())){
			
				SendData response = (SendData) ois.readObject();
				double res = MyCalculate(response.getNum1(), response.getNum2(), response.getOp());
				response.setResult(res); // 계산된 결과 리턴
				
				//클라이언트로 계산된 결과 보내자
				oos.writeObject(response);
				oos.flush();
		}catch(Exception e) {
				e.printStackTrace();
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
