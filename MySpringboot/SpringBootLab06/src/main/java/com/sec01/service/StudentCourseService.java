package com.sec01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.repository.CourseRepository;
import com.sec01.repository.StudentRepository;

@Service
public class StudentCourseService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	public void addStudent(String studentName, String courseTitle) {
		Course course = new Course(null, courseTitle, new ArrayList<>());
		courseRepository.save(course);
		
		Student student = new Student(null, studentName, List.of(course));
		studentRepository.save(student);
	}
	
	public void addCourse(String courseTitle) {
		Course course = new Course(null, courseTitle, new ArrayList<>());
		courseRepository.save(course);
	}
	
	public void deleteStudent(Long Student) {
		studentRepository.deleteById(Student);
	}
	
	public void deleteCourse(Long course) {
		courseRepository.deleteById(course);
	}
}
