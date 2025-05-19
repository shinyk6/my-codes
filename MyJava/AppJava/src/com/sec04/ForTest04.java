package com.sec04;

public class ForTest04 {	
	public static void main(String[] args) {
	
	    for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) { // j는 i의 개수만큼 ++하며 별을 찍음
                System.out.printf("%3c",'*');
            }
            System.out.println();
        }
	}
}


