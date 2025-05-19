package com.sec17.tcpexam03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

//채널을 생성해서 논블로킹을 지정하고 버퍼객체에 데이터를 I/O 하는 방법
public class MyServerNio {
    public static void main(String[] args) throws IOException {
        System.out.println("🌐 NIO 서버 시작");

        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(9999));
        server.configureBlocking(false); //환경설정 블로킹
        server.register(selector, SelectionKey.OP_ACCEPT);   //여기까지가 MyServer의 Socket	socket = serverSocket.accept(); 부분

        while (true) {
            selector.select(); // 블로킹처럼 보이지만 내부는 이벤트 기반 select로 실행시킴
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();

                if (key.isAcceptable()) { //키값이 승인이 되면
                    SocketChannel client = server.accept(); //소켓채널로 리턴 받음
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_WRITE);
                    System.out.println("클라이언트 연결됨 (NIO)");
                }

                if (key.isWritable()) { 
                    SocketChannel client = (SocketChannel) key.channel(); //채널이 가지고 있는 값 리턴받아 
                    ByteBuffer buffer = ByteBuffer.wrap("서버가 클라이언트에게".getBytes("UTF-8")); //바이트버퍼에 넣음
                    client.write(buffer);
                    client.close();
                }
            }
        }
    }
}
