package com.student.view;

import java.util.List;
import com.student.model.Student;

public class StudentConsolView {
	
	//전체 출력
	public void showAllList(List<Student> list) {
		for(Student s : list) {
			System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getMajor() + "\t" + s.getGrade());
		}
	}
	
	//알림 메세지
	public void showMessage(String message) {
		System.out.println("[알림]" + message);
	}
}
