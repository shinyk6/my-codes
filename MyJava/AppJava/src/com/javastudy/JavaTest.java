package com.javastudy;

class Employee{
	String name;
	String id;
	int basicSalary = 100000;
	
	
	public Employee() {
		super();
	}

	void calculateSalary(){};
}


class Manager extends Employee{
	
	int managerialBonus=10; //관리자 수당
	
	@Override
	void calculateSalary() {
		System.out.println(basicSalary+managerialBonus);
	}	
}

class SalesPerson extends Employee{
 	int commission=20; //판매수당
 	
	@Override
	void calculateSalary() {
		System.out.println(basicSalary+commission);
	}
}


class Engineer extends Employee{
	int techBonus=30; //기술수당

	@Override
	void calculateSalary() {
		System.out.println(basicSalary+techBonus);
	}	
}

public class JavaTest {
	public static void main(String[] args) {
		Manager manager = new Manager();
		SalesPerson person = new SalesPerson();
		Engineer engineer = new Engineer();
		System.out.printf("매니저 수당: ");
		manager.calculateSalary();
		System.out.printf("판매자 수당: ");
		person.calculateSalary();
		System.out.printf("엔지니어 수당: ");
		engineer.calculateSalary();
	}
}





