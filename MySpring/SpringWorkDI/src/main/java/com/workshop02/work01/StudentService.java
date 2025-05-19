package com.workshop02.work01;

import java.util.List;

public class StudentService {

	private List<Student> student;
	
	public void setStudents(List<Student> student) {
		this.student = student;
	}
	
	public void PrintAllInfo() {
		//모든 학생 정보를 출력
		System.out.println(this.student);
	}
	
	public void printStats() {
		//나이, 신장, 몸무게 평균출력(Stream API활용)
	}
	
	
	
}
