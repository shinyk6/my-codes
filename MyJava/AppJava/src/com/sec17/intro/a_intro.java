package com.sec17.intro;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;
import java.util.zip.GZIPInputStream;

// 웹페이지 요청 후 페이지를 다운로드 받아서 출력 해보자.
// [1] 가상 스레드
// [2] URL 주소 요청 openStream
// [3] executor.awaitTermination(10, TimeUnit.SECONDS); // 10초 후 완전히 종료
// GZIPInputStream()  .gz 확장자 압축파일을 풀어보자. 
public class a_intro {
	public static void main(String[] args) throws InterruptedException {

		String urlString = "https://www.python.org";

		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor(); //가상 스레드로 생성해서 작업해줘

		executor.submit(() -> { //submit : 실행
			try {
				URL url = URI.create(urlString).toURL();

				// GZIP 압축 해제 후 UTF-8로 읽기
				try (InputStream rawStream = url.openStream(); // www.python.org/index.html 다운로드
						//이미 소켓통신으로 연결 됨 - Stream 생성됨
						InputStream decodedStream = new GZIPInputStream(rawStream); //그냥 가져오면 인코딩이 다 깨짐-inputstream으로 가져온 것을 gzip으로 압축해제
						BufferedReader reader = new BufferedReader( //라인단위로 처리하는 read는 BufferedReader밖에 없음
								new InputStreamReader(decodedStream, StandardCharsets.UTF_8))) {

					System.out.println("\n [웹 페이지 내용 시작]");
					String line;
					while ((line = reader.readLine()) != null) { //BufferedReader의 readLine
						System.out.println(line);
					}
					System.out.println(" [웹 페이지 내용 끝]");
				}
			} catch (Exception e) {
				System.err.println("오류 발생: " + e.getMessage());
			}
		});

		//try-resource 걸어도 됨
		executor.shutdown(); // 종료요청 - VM에게(executor는 vm이 관리)
		executor.awaitTermination(10, TimeUnit.SECONDS); //10초 후 완전 종료해줘1
	}
}
