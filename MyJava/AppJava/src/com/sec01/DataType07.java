package com.sec01;

public class DataType07 {
	//byte short char int float double long
	public static void main(String[] args) {		 
		 double  d= 3.14F;		 //묵시형 형변환 (작은 방->큰방 자동!)
		  int  res=(int)d;		//명시형으로 캐스팅- 소수점을 빼고 3만 대입시킴		
		  
		  System.out.println( "promotion d="+ d) ;		  
		  System.out.println(" casting res ="+ res);	 
	}
}
