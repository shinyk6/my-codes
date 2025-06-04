package com.sec01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.repository.CourseRepository;
import com.sec01.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentCourseService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	// [1] 전체 학생 목록 조회
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	// [2]전체 과목 목록 조회
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// [3] 학생 추가 (기존 강의에 연결)
	public void addStudent(String name, List<Long> courseIds) { //한 학생이 여러 개의 과목을 수강-List객체로 받아옴 
		Student student = new Student();
		student.setName(name);

		
		//중간 테이블 값 추가
		if (courseIds != null && !courseIds.isEmpty()) { //데이터가 있을 경우만
			List<Course> courses = courseRepository.findAllById(courseIds); //코스id로 코스 정보를 찾아서
	
			for (Course course : courses) {
				student.getCourses().add(course); //
				course.getStudents().add(student);
			}
		}
		
		studentRepository.save(student);
	}
	
	
	// [4] 과목 추가 (과목만)
//	public void addCourse(String courseTitle) {
//		Course course = new Course(null, courseTitle, new ArrayList<>());
//		courseRepository.save(course);
//	}
	
	// [4] 과목 추가 (과목만)
	public void addCourse(String title) {
	Course course = new Course();
	course.setTitle(title);
	courseRepository.save(course);
	}

	// [5] 학생 삭제
	public void deleteStudent(Long id) {
	studentRepository.deleteById(id);
	}

	// [6] 과목 삭제
	public void deleteCourse(Long id) {
	courseRepository.deleteById(id);
	}
	
	// [7] 특정 과목을 수강하는 학생 목록 조회
	public List<Student> getStudentsByCourseTitle(String courseTitle) { 
		return studentRepository.findByCourseTitle(courseTitle); 
	} 
	
	// [8] 원하는 필드를 dto를 이용해서 Projections 사용하여 조회
	public List<StudentCourseDto> getStudentCourseList(){
		return studentRepository.findStudentCourseDtoList();
	}

}
