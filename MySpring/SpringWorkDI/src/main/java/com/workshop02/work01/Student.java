package com.workshop02.work01;

public class Student {
	
	String name;
	public int age;
	public int height; 
	public int weight; 
	
	public Student() {}

	public Student(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	
	public String studentInfo() { //문자열로 반환
		return String.format("%s %s %s %s", name, age, height, weight);
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
	
	
	
	
}
