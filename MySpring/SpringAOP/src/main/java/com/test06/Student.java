package com.test06;

public class Student implements Person {
	
	public Student() {
		System.out.println("Student 기본 생성자.");
	}

	@Override
	public void classWork() {
		System.out.println("[학생] classWork");
	}

	@Override
	public void homeWork() {
		System.out.println("[학생] homeWork");		
	}

	@Override
	public void meeting(String topic) {
		System.out.println("[학생] meeting " + topic);
	}
	
	public void study() {
		System.out.println("[학생] study()");	
	}
	public void relax() {
		System.out.println("[학생] relax()");	
	}
	public void eat(String food) {
		System.out.println("[학생] eat " + food);	
	}
	public int getScore() {
		System.out.println("[학생] getScore ... ");
		return 100;
	}
}
