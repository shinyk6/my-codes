package com.sec01.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.repository.CourseRepository;
import com.sec01.repository.StudentRepository;

@SpringBootTest
@AutoConfiguration
class StudentCourseControllerTest { //콘솔 확인

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	void testShowAllPages() throws Exception {

		//테스트용 학생/강의 저장
		Student student = new Student();
		student.setName("홍길동");
		studentRepository.save(student);
		
		Course course = new Course();
		course.setTitle("자바 프로그래밍");
		courseRepository.save(course);
		
		//학생 목록 페이지 테스트
//		mockMvc.perform(get("/students"))
//				.andExcept(status().ikOk())
//				
		
	
	}
	

}
