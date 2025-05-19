package com.sec17.tcpexam;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


// 블로킹 : 실제로 스레드가 멈추어 있는 상태
public class MyServer {
	public static void main(String[] args) throws IOException {
		// 1.ServerSocket(9999)을 생성하여 특정 포트에서 클라이언트의 접속을 대기한다.
		System.out.println("나 서버야");
		//ServerSocket serverSocket = null;
		//Socket socket = null; 
		
		try(ServerSocket serverSocket = new ServerSocket(9999);
			Socket	socket =  serverSocket.accept(); // 2.ServerSocket의 accept() 메서드를 이용하여 클라이언트의 접속을 기다린다. ->블로킹 상태
					// 3.클라이언트의 접속 요청이 들어오면 accept() 메서드가 실행되어 클라이언트와의 통신을 위한 Socket 객체를 생성한다.
			OutputStream os = socket.getOutputStream();	//4. OuputStream획득
		){
			 //클라이언트가 소켓으로 접속하면 소켓으로 받아야함.
			//클라이언트가 접속하면 Socket객체 생성됨
											//accept메소드로 승인되어 연결됨
			System.out.println("클라이언트가 접속했어"); //연결이 되면 stream이 존재
	
			os.write("서버가 클라이언트에게".getBytes("UTF-8")); //write가 byte형식이기에
		}
		
		// 4.생성된 Socket 객체로부터 통신을 위한 InputStream, OutputStream을 얻는다.
		// 5.InputStream, OutputStream을 이용하여 클라이언트와 통신한다.
		
	}
}
