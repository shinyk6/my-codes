package com.sec06;

import java.util.Objects;

public class U_Address{
	////멤버 변수 은닉화
	private String name;
	private String addr;
	private String tel;

	

	public U_Address() { //기본 생성자 -> new U_Address();
	
	}
	
	
	
	
	public U_Address(String name) { 	//매개인자가 있는 생성자 -> 오버로드 된 생성자  this로 자기들끼리 부를 수 있음 
										//생성자는 몇개를 만들어도 상관 없음 
		super();
		this.name = name;
		this.addr = "서울";
		this.tel = "02-000";
	}

	public U_Address(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override //toString 재정의
	public String toString() {
		return String.format("U_Address [getName()=%s, getAddr()=%s, getTel()=%s]", getName(), getAddr(), getTel());
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		U_Address other = (U_Address) obj;
		return Objects.equals(this.name, other.name);	//내가 가지고 있는 name과 넘어오는 name이 같은지 비교
														//this = 현재 오브젝트를 지칭하는 연산자
	}
	
	//equals 로 이름만 비교
	public static void main(String[] args) {
		U_Address u1 = new U_Address("홍길동","111","1111");
		U_Address u2 = new U_Address("정길동", "22","2221");
		
		
		System.out.println("각 객체의 값인 이름이 같은지 다른지 : " + u1.equals(u2)); 
		System.out.println(u1.hashCode()); 
	} //-> u1, u2가 각각 가지고 있는 이름이 동일한지 확인 // ==연산자는 주소만 비교

	
	
	
	
	
	
	
	

}