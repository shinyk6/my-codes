package com.sec04;

public class ForTest03 {
	public static void main(String[] args) {
		
	        for(int i=1; i<=2; i++) {	//중첩 for문
	        	
	            for(int j=1; j<=3; j++) {
	                System.out.println("i="+i +"  j="+j);
	            }
	            System.out.println(); //for문에 포함되어있는 줄바꿈
	        }
	}
}



