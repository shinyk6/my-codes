package com.sec13.myNio;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class h_NIOChar {
	//문자열 단위  : write()	Files.newInputStream()
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("b.txt");
		
		//문자열 쓰기
		List<String> lines = List.of("public", "static", "void main");
		//write(Path path, Iterable<? extends CharSequence> liens, OpenOption...options)
		Files.write(path, lines); // 컬렉션의 하위 인터페이스인 List, Set <CharSequence의 구현체> 다 올수 있음
		System.out.println("저장 완료!!");
		
		//문자열 읽기
		List<String> lines02 = Files.readAllLines(path);
		lines02.forEach(System.out::println);
		
		Runtime r = Runtime.getRuntime();
		r.exec("notepad.exe");
	}
}
