package com.sec01.service;


import java.util.List;


import org.springframework.stereotype.Service;
import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.repository.CourseRepository;
import com.sec01.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentCourseService {
/*
		필드 주입  -> 런타임 까지 의존성 누락 유무를 감지 못함
		
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
*/
	
	
	// 생성자 주입 (권장 사항) -> final로 불변유지, 컴파일 타입 시 확인 가능, 컴파일 시점 명확하게 주소 확인! (필드주입은 다 안됨)
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	
	public StudentCourseService(StudentRepository studentRepository, CourseRepository courseRepository) {
		
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	// [1] 전체 학생 목록 조회
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	// [2]전체 과목 목록 조회
	public List<Course> getAllCourses(){
		return courseRepository.findAll();
	}
	
	// [3] 새 학생 추가 (과목 연결도 처리)
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
	

}
