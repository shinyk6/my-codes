package com.myExam;




class apple{
	
}

class bag{
	
	public apple appleCall() {
		
		return new apple();
	}
}

public class MethodTest {

	public static void main(String[] args) {
		
		bag b = new bag();
		
		apple a = b.appleCall();

	}
	


}
