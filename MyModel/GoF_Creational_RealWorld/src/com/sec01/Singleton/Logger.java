package com.sec01.Singleton;

public class Logger {
	
	//싱글톤 문법1. 생성자 은닉 private
    private static Logger instance = new Logger();
    private Logger() {}

    //2. 한번 생성된 객체를 public static으로 리턴 -> 새로운 객체 생성을 막음
    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
