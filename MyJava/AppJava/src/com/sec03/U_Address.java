package com.sec03;


public class U_Address{
	////멤버 변수 은닉화
	private String name;
	private String addr;
	private String tel;
	/*
	///멤버 메소드
	///이름
	public void setName(String name) {
		this.name = name;
	}
	public String getName() { //return값이 있기에 String데이터타입지정
		return name;    //return this.name
	}	
	///지역
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddr() {
		return addr;    //return this.addr
	}	
	///전화번호
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTel() {
		return tel;    //return this.tel
	}	
	
	
	///출력 사용자 메소드 추가 -> 멤버가 많아지면 일일이get해서 호출하기 힘들기에
	public void Prn() {
		System.out.printf("%10s %10s %10s \n", this.getName(), this.getAddr(), this.getTel());
	}	//각각의 get/set이 있는 상태에서 
	
//	-->전부 non-sataic -인스턴스 메소드 heap에 객체를 생성
	
	//재정의
	@Override //어노테이션 : 컴파일 할 때 사라지지 않는 주석
	public String toString() {
		return String.format("%10s %10s %10s \n", this.getName(), this.getAddr(), this.getTel());
	} //System.out.printf과 매개변수가 같음.(printf같은 의미)
		//객체만 호출해서 출력하고 싶으면 이 패턴 사용.

	*/
	
	public static void main(String[] args) {
		U_Address a1 = new U_Address(); 				//선언되어있는 주소만 받음
		U_Address b1 = new U_Address();
		
	//	a1.Prn();		//각각의 멤버를 가지고 있는 메소드가 출력됨 a1'Prn()
	//	b1.Prn();		//b1'Prn()
		
		a1.setName("111");
		a1.setAddr("111");
		a1.setTel("111");
		System.out.println(a1);		//주소를 출력하는 것이 아닌 재정의한 내용이 불러와져 출력됨 
									//a1.toString() 
		System.out.println(b1);		//b1.toString()
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

}