package com.sec06;

//Person(String name, int age){}, name(),age(),toString(),equals(), hashcode()
record Person(String name, int age) {} //이 원형만 선언하면 빈방 못만듦, 값을 줘야함
public class MTest01 {

	public static void main(String[] args) {
		Person[] people = {new Person("Alice", 30),      //자유영역 공간에 두 개의 방만듦
							new Person("Bob",25)};		//{} 를 만나서 인덱스를 할당받게 됨 [0], [1]
														//두개의 방 주소를 people이 참조->마치 다차원배열처럼 만들어짐		
		Person[] people02 = new Person[2];
		people02[0] = new Person("Alice", 30);			//위 배열코드와 같은 의미
		people02[1] = new Person("Bob", 25);
		
		System.out.println(people);	//배열의 주소는 앞에 [ 가 있음
		
		prn(people);
		prn(people02);
		
	}

	private static void prn(Person[] people) {
		for (Person res : people) {
				System.out.println(res); // res.toString()
		}
		System.out.println();
	}
}
