package com.sec17.intro;
//압축된 .gz → 다시 읽기 (복원) 
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class a_zipDecompression2 {
    public static void main(String[] args) {
        File gzipFile = new File("C:\\Users\\user-pc\\Documents\\유갱\\멋사\\2025-04-16\\sec17.zip"); 

        try (FileInputStream fis = new FileInputStream(gzipFile);
             ZipInputStream gzipIn = new ZipInputStream(fis)) { //폴더

        	ZipEntry entry = null; // 파일 (폴더 안의 대상들을 entry로 간주)
        	
        	while((entry = gzipIn.getNextEntry()) != null ) {
        		 System.out.println(" 압축 해제 중 : " + entry.getName());
        		 
                BufferedReader br = new BufferedReader(new InputStreamReader(gzipIn, StandardCharsets.UTF_8));
            	
               
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                gzipIn.closeEntry();  // while안에서 열었기때문에 닫아주기 
        	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

