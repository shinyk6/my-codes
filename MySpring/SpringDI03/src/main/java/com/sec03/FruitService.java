package com.sec03;

public class FruitService {

	private Fruit fruit; //Fruit(I)을 멤버로 가짐 - 인터페이스 추상 선언
	 
	public void setFruit(Fruit fruit) { //setter 주입 
		this.fruit = fruit;
	}
	
	public void printName() {
		System.out.println(fruit.getName());
	}
}
