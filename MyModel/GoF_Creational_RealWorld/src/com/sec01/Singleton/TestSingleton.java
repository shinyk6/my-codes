package com.sec01.Singleton;

public class TestSingleton {
    public static void main(String[] args) {
    	// new 연산자를 사용하지 않고 객체가 정적으로 생성한 메소드를 호출 - 싱글톤
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("System started");
        System.out.println("Same instance: " + (logger1 == logger2));
    }
}
