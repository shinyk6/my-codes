package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread2 {
    public static void main(String[] args) throws InterruptedException {
    	
    	Thread.Builder builder = Thread.ofVirtual();
    	
    	switch(builder){
    	case Thread.Builder.OfVirtual v -> System.out.println("가상 스레드 생성했다.");
    	case Thread.Builder.OfPlatform p -> System.out.println("플랫폼 스레드 생성했다.");
    	}
    	
        Thread.sleep(1000); 
    }
}
