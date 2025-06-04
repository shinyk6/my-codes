package com.sec01.repository;

import java.util.List;

import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.Student;

// 1. 사용자 추가 쿼리 메소드 선언
// 특정 과목을 입력하면 수강하는 학생의 목록을 리턴
//select * from student join course on(student.id=course.id)
//				where title = "특정과목";
public interface StudentRepositoryCustom {
	List<Student> findByCourseTitle(String courseTitle);
	List<StudentCourseDto> findStudentCourseDtoList();
}
