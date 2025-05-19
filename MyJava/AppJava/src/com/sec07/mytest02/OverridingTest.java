package com.sec07.mytest02;

class Employee {
    private final String name;	//final이 있기에 setter가 없음 (재정의하지 않고 초기값만 가진 상수)
    private final int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String getDetails() {
        //return "Name: " + name + "\nSalary: " + salary; //현재 정보를 리턴
    	return "Name: " + this.getName() + "\nSalary: " + this.getSalary(); //웬만하면 get으로 리턴
    }

    public void prn() {
        System.out.println("I'm an Employee");
    }
}

class Manager extends Employee { 
    private final String department;

    public Manager(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public String getDetails() {
        //return "Name: " + getName() + "\nManager of: " + department;
    	return super.getDetails() + "\nManager of: " + department;  //선조의 멤버를 호출 할 때는 super꼭 명시해주기. 명시하지않으면 this와 같음
    }

    public void disp() {
        System.out.println("I'm a Manager");
    }
}

public class OverridingTest {
    public static void main(String[] args) {
        Employee emp = new Manager("John Doe", 5000, "IT");
        
        System.out.println(emp.getDetails()); // 동적 바인딩으로 Manager의 getDetails() 호출 (외부에서 호출 할 때)
        emp.prn(); // Employee의 prn() 호출

        
        if (emp instanceof Manager manager) {
            manager.disp();
        }
    }
}
