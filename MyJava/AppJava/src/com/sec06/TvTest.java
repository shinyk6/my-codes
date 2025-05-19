package com.sec06;

public class TvTest {
	public static void main(String[] args) {
	/*	Tv tv1 = new Tv("INFINIA", 1500000,"LED TV");
		Tv tv2 = new Tv("XCANVAS",1000000,"LCD TV");
		Tv tv3 = new Tv("CINEMA",2000000,"3D TV");
	*/

		//case 1 :각 객체 생성된 주소를 배열에 담아서 처리 
		//Tv[] tvs = { tv1, tv2, tv3 };

		//case 2:  초기값 전달 하면서 배열에 담아서 처리 		
		/*Tv[] tvs = new Tv[] {
				new Tv("INFINIA", 1500000,"LED TV"),
				new Tv("XCANVAS",1000000,"LCD TV"),
				new Tv("CINEMA",2000000,"3D TV")				
		}; */		
		
		// case 3: 동적메모리 확보 후 값 대입  
		Tv[] tvs = new Tv[3];
		tvs[0]=	new Tv("INFINIA", 1500000,"LED TV");
		tvs[1]=	new Tv("XCANVAS",1000000,"LCD TV");
		tvs[2]=	new Tv("CINEMA",2000000,"3D TV");				
		
		prn(tvs);
		
		System.out.println("XCANVAS 가 가진 가격을 4000000으로 변경 후 전체 출력");
		tvs[1].setPrice(4000000);
		prn(tvs);
		System.out.println("제품명이 CINEMA인 TV 가격을 500000으로 변경 후 전체 출력");
		for(Tv tv : tvs) { //foreach
			if(tv.getName().trim().equals("   CINEMA".trim())) { //String클래스를 사용 할 때는 공백이 들어갈 수 있으니 trim을 쓰기
				tv.setPrice(500000);
			}
		}
		prn(tvs);
		
	}
	
	public static void prn(Tv[] tvs) {
		System.out.println("전체 출력");
		for(Tv tv : tvs) { //foreach
			System.out.println(tv);
		}
	}
}
