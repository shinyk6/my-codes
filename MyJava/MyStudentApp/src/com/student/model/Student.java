package com.student.model;

public class Student {
	
	private int id;
	private String name; //이름
	private String major; //전공
	private int grade; //성적
	
	public Student(int id, String name, String major, int grade) { 
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.grade = grade;
	}


	public Student(String name, String major, int grade) { // id값은 자동 증가하기에 id를 제외 한 나머지를 매개변수로 받는 생성자
		super();
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	
	public Student() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}
}
