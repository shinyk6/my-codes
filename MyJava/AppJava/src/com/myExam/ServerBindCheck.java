package com.myExam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.net.InetSocketAddress;

public class ServerBindCheck {

	public static void main(String[] args) {
		
		try {
			
			// 포트번호는 지정,   IP는 지정하지 않음
			 ServerSocket serverSocket = new ServerSocket(9999);  
			
			// 바인딩 된 IP 주소와 포트를 출력
			 InetSocketAddress socketAddrss = (InetSocketAddress) serverSocket.getLocalSocketAddress();
			 //InetSocketAddress가 serverSocket보다 하위의 클래스라 다운캐스팅 함. 다형성에서는 **하위 객체를 상위 타입에 담는 것**이 가능하지만,
			 //그 반대의 경우는 에러가 남-> 그럼 왜 굳이 캐스팅을? -> S
			 //serverSocket
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
