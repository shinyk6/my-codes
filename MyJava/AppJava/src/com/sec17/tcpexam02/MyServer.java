package com.sec17.tcpexam02;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args){
		
		System.out.println("나 서버야");
		
		try(ServerSocket serverSocket = new ServerSocket(9999)){  // 1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
			while(true) {
				Socket	client_socket =  serverSocket.accept(); // 2.ServerSocket의 accept() 메서드를 이용하여 클라이언트의 접속을 기다린다.   //클라이언트가 소켓으로 접속하면 소켓으로 받아야함.
				System.out.println("클라이언트가 접속했어"); //3. 클라이언트가 접속하면 Socket 객체 생성됨	// 3.클라이언트의 접속 요청이 들어오면 accept() 메서드가 실행되어 클라이언트와의 통신을 위한 Socket 객체를 생성한다. //accept메소드로 승인되어 연결됨
			 
				//4. 클라이언트 별로 가상 스레드로 처리
				Thread.startVirtualThread(()-> handleClient(client_socket) );
			}
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

	private static void handleClient(Socket client_socket) { //runnable의 run()가 void형이라서
		//클라이언트에게 서버가 메세지를 보내보자.
		try(client_socket;
			OutputStream os = client_socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))){
				writer.write("가상 스레드 서버에서 응답한다. \n");
				writer.flush(); //writer 후 flush로 닫아주기
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
