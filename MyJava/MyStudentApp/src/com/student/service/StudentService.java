package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {

	public int insertStudent(Student s);
	public int deleteStudent(Student s);
	public int updateStudent(Student s);
	public List<Student>selectAllStudent();
}
