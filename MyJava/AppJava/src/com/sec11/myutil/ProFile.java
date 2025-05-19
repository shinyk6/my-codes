package com.sec11.myutil;

public class ProFile<T> {//아무타입으로 받겠음
	private String name;
	private T dept;
	public ProFile(String name, T dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getDept() {
		return dept;
	}
	public void setDept(T dept) {
		this.dept = dept;
	}	
}
