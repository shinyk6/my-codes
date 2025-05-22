package com.mydb.core;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpAppMain {
	public static void main(String[] args) {
		var ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		EmpService service = ctx.getBean(EmpService.class);
		service.getAll().forEach(System.out::println);

		//List<Emp> emps = service.getAll();
		// AOP 종료됨 → 여기서 After 출력 끝

		// 결과 출력 (AOP와 무관한 일반 출력)
//		for (Emp e : emps) {
//			System.out.println(e);
//		}
	
	
		try {
			Emp newEmp = new Emp(2222, "TEST", "Test", 10);
			service.insertEmpwithFail(newEmp);
		}catch(Exception e) {
			System.out.println("예외 발생: " + e.getMessage());
		}
		
		System.out.println("======================================");
		service.getAll().forEach(System.out::println);
	}
}
