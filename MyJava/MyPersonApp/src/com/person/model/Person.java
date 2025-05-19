package com.person.model;

public class Person  {// entity, dao 역할
	private String name;
	private String address;
	private String phone;
	
	
	public Person() {
		super();
	}
	
	public Person(String name, String addr, String phone) {
		super();
		this.name = name;
		this.address = addr;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String addr) {
		this.address = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
