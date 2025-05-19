package com.sec13.myio;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Student implements Serializable {
	//해당클래스를 바이트 스트림으로 변환하겠다. ->직렬화

	private String name;
	public static int age; //직렬화 대상이 아님
	private int height;
	private transient int weight;	//static은 아니지만 직렬화에서 제외하고 싶을 때(transient)

	public Student() {
		super();
	}
	
	public Student(String name, int age, int height, int weight) {
		this.name = name;
		Student.age = age; //static 변수 초기값
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}
	
	@Override
	public String toString() {
		return
		String.format("%10s %5d %5d %5d \n", this.getName(), Student.age, this.getHeight(),this.getWeight());
	}
}