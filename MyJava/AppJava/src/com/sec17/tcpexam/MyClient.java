package com.sec17.tcpexam;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;

public class MyClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//1. 서버와 통신을 위한 Socket 객체를 생성한다. 이때 접속 요청할 서버의 IP주소와 Port 번호를 매개변수로 지정한다. 
	
		//try-catch 대신 try-with-resource 구문 사용
		try(Socket socket = new Socket("localhost", 9999);  // ip, port를 매개변수로 전달 socket만 있으면 클라이언트가 됨
			//2. Socket 객체로부터 서버와의 통신을 위한 InputStream, OutputStream을 얻는다.
			//서버에서 OutputStream을 썼으니, 클라이언트에서 InputStream으로 읽음
			BufferedReader br = new BufferedReader (new InputStreamReader(socket.getInputStream(), "UTF-8"))){ //인코딩
			//Stream객체는 character set을  가지고 있음 
			  
			 System.out.println("클라이언트야 !!");
			 System.out.println("서버가 준 메세지 : " + br.readLine());
		}
		/*			 
			InputStream ios = socket.getInputStream();
			 int r = 0;
			 
			 while( (r = ios.read()) != -1) {
				 System.out.println(r);
			 }
			 ios.close();
		*/	 
		 
		}
		//3. 생성된 InputStream, OutputStream을 이용하여 서버와 통신한다. 
		
		
		//4. 통신이 완료되면 통신에 사용된 IO스트림과 Socket 객체를 close() 한다. 

	}

