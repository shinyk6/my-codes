package com.sec01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.thymeleaf.spring6.expression.Fields;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sec01.dto.StudentCourseDto;
import com.sec01.entity.QCourse;
import com.sec01.entity.QStudent;
import com.sec01.entity.Student;

@Repository
public class StudentRepositoryImpl extends QuerydslRepositorySupport implements StudentRepositoryCustom {

	private final JPAQueryFactory queryFactory;
	
	// 생성자 명시로 수동 값전달
	public StudentRepositoryImpl(JPAQueryFactory queryFactory) {
		
		//Repository가 명시된 엔티티로 결정
		super(Student.class); //선조(QuerydslRepositorySupport)에게 엔티티(Student)를 지정 대입
		this.queryFactory = queryFactory;
	}


	@Override
	public List<Student> findByCourseTitle(String courseTitle) {
		QStudent student = QStudent.student; //싱글톤으로 생성된 객체 (어딘가 만들어 메모리에 올린 것을 호출)
		QCourse course = QCourse.course; //싱글톤으로 생성된 객체
		return queryFactory
				.selectFrom(student)
				.join(student.courses, course)
				.where(course.title.eq(courseTitle))
				.fetch();
	}


	@Override //Projection 사용
	public List<StudentCourseDto> findStudentCourseDtoList() {
		QStudent student = QStudent.student; //싱글톤으로 생성된 객체 (어딘가 만들어 메모리에 올린 것을 호출)
		QCourse course = QCourse.course; //싱글톤으로 생성된 객체
		
//		return queryFactory
//				.select(Projections.constructor(StudentCourseDto.class, student.name, course.title)) //생성자로 가져오기 (DTO에 기본 생성자 없어도 문제 없음)
//				.from(student).join(student.courses, course).fetch();
		
		
		return queryFactory
				.select(Projections.fields(StudentCourseDto.class, student.name.as("studentName"), course.title.as("courseTitle"))) //필드로 가져오기 (DTO에 기본생성자가 명시되어있어야함)
				.from(student)
				.join(student.courses, course)
				.fetch();
		
	}
	//Projections.constructor() 사용하려면 -> DTO 생성자가 명시되어야 함 -> Querydsl에서 dto 생성할 때만 사용함
	
	/*
	 * 
	 * 
	 * 
	 * */
	
	
	
	
	
	
	
}
