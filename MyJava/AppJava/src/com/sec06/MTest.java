package com.sec06;

//Address(String name, String addr, String tel), getter, toString(), equals(), hashcode()
record Address(String name, String addr, String tel) {}			 //이름만 선언하면 자동으로 만들고 싶을 때   record앞에 접근제한자 붙여야함
public class MTest {

	public static void main(String[] args) {
		
		Address a1 = new Address("홍길동","서울","02-000");
		Address a2 = new Address("홍길동","서울","02-000");
		System.out.println(a1);
		System.out.println(a1.tel());
		System.out.println(a1.toString());
		
		System.out.println(a1.equals(a2)); 
	}

}
