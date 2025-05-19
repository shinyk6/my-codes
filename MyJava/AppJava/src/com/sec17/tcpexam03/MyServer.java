package com.sec17.tcpexam03;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.ServerSocket.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyServer {
	
	private static final AtomicInteger clientCounter = new AtomicInteger(1); //고유 클라이언트 ID를 위한 카운트 체크 
	private static final File logFile = new  File("client_log.txt");
	
	public static void main(String[] args){
		
		System.out.println("나 서버야");
		
		try(ServerSocket serverSocket = new ServerSocket(9999)){
			while(true) {
				Socket	client_socket =  serverSocket.accept();
				
				int Clientid = clientCounter.incrementAndGet();
				String c_IP = client_socket.getInetAddress().getHostAddress();
				int c_PORT = client_socket.getPort();
				LocalDateTime c_time = LocalDateTime.now();
				
				System.out.printf("[클라이언트 %d 접속했어] IP:%s  PORT:%d  TIME:%s \n", Clientid, c_IP, c_PORT, c_time); 
				
				logFileClient(Clientid, c_IP, c_PORT, c_time);
			 
				//4. 클라이언트 별로 가상 스레드로 처리
				Thread.startVirtualThread(()-> handleClient(client_socket, Clientid) );
			}
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

	private static void logFileClient(int clientid, String c_IP, int c_PORT, LocalDateTime c_time) {
			String dateString = c_time.toLocalDate().format(DateTimeFormatter.ISO_DATE); //ISO_DATE : YYYY-MM-DD
			File Mylogfile = new File("client_log_" + dateString + ".txt"); //접속 로그가 날짜별로 파일 생성

			try(BufferedWriter logwriter = 
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(Mylogfile, true), StandardCharsets.UTF_8))){
				
				String str = String.format("[클라이언트 %d] IP:%s  PORT:%d  TIME:%s \n", clientid, c_IP, c_PORT, c_time);
				
				logwriter.write(str);
				
			}catch(IOException e) {
				e.printStackTrace();
			};
			
		
	}

	private static void handleClient(Socket client_socket, int Clientid) { //runnable의 run()가 void형이라서
		//클라이언트에게 서버가 메세지를 보내보자.
		try(client_socket;
			OutputStream os = client_socket.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"))){
				writer.write("[서버 응답] 클라이언트" + Clientid + "님, 안녕하세요!!!!");
				writer.flush(); //writer 후 flush로 닫아주기
				System.out.printf("[클라이언트 %d] 응답 완료 !! - 연결종료 \n", Clientid);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
