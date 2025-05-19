package com.javastudy;

public class CustomException extends RuntimeException {

	
	CustomException() {}
	
	CustomException(String message){
	
		super(message);
	}
	
	
	public static void main(String[] args) {
		try {
			exceptionTest();	
		}catch(CustomException e) {
			System.out.println("커스텀 예외 test");
			e.getMessage();
			e.printStackTrace();
		}
		
	}
	
	
	public static void exceptionTest() throws CustomException {
		throw new CustomException("예외 테스트!!");
	}

}
