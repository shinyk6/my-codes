package com.sec17.intro;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//문자열 → GZIP 압축 → 파일 저장 
public class a_zipCompression2{
    public static void main(String[] args) {
        String data = """
                Hello, this is compressed content.
                Java GZIP is easy to use!
                Virtual Thread도 문제 없이 동작합니다 
                """;

        File gzipFile = new File("output02.zip"); //폴더

        try (FileOutputStream fos = new FileOutputStream(gzipFile);
             ZipOutputStream gzipOut = new ZipOutputStream(fos)) {//Zip 사용
        	
        	OutputStreamWriter writer = new OutputStreamWriter(gzipOut, StandardCharsets.UTF_8);
            
        	//압축항목을 정의하자.
        	ZipEntry ze = new ZipEntry("a.txt"); //파일을 폴더에 담아야함 ZipEntry를 통해 읽고 쓰고 해야함
        	gzipOut.putNextEntry(ze);
        	writer.write(data);
        	writer.flush(); //지우기

        	
            System.out.println(" 압축 완료: " + gzipFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
