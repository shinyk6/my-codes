package com.student.service;

import java.util.List;

import com.student.dao.StudentDao;
import com.student.dao.StudentDaoImpl;
import com.student.model.Student;

public class StudentServiceImpl implements StudentService {

	//메소드에 final을 붙일 경우, 해당 메소드를 오버라이드 불가
	private final StudentDao dao = new StudentDaoImpl();
	
	
	@Override
	public int insertStudent(Student s) {
		return dao.insertStudent(s);	
	}


	@Override
	public int deleteStudent(Student s) {
		return dao.deleteStudent(s);
	}


	@Override
	public int updateStudent(Student s) {
		return dao.updateStudent(s);
	}


	@Override
	public List<Student> selectAllStudent() {
		return dao.selectAllStudent();
	}
	
	

}
