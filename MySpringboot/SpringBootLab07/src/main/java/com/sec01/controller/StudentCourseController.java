package com.sec01.controller;

import java.util.List;
import java.util.stream.Collectors;
import com.sec01.dto.CourseDto;
import com.sec01.dto.StudentRequestDto;
import com.sec01.dto.StudentResponseDto;
import com.sec01.dto.StudentsAndCoursesResponse;
import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.service.StudentCourseService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") // cors허용 (3000포트로 접속 가능)
@RestController
@RequestMapping("/api")
public class StudentCourseController {

	// @Autowired 필드주입
	// private StudentCourseService service;

	// 생성자 주입
	private final StudentCourseService service;

	public StudentCourseController(StudentCourseService service) {
		this.service = service;
	}

	// [1] 모든 학생 + 과목 목록 조회(courses포함)
	@GetMapping("/students")
	public StudentsAndCoursesResponse showStudents() {
		List<Student> students = service.getAllStudents(); // DB 리턴 Entity활용
		List<Course> courses = service.getAllCourses(); // DB 리턴 Entity활용

		// [1-1] 학생 응답 DTO 변환
		List<StudentResponseDto> studentDtos = students.stream() // json형식이기에 key-value로 보냄
				.map(student -> new StudentResponseDto( // StudentResponseDto 객체 생성
						student.getId(),
						student.getName(),
						student.getCourses().stream()
								.map(c -> new CourseDto(c.getId(), c.getTitle())) // CourseDto 객체 생성
								.collect(Collectors.toList())

				)).collect(Collectors.toList());

		return new StudentsAndCoursesResponse(studentDtos, courses);
	}

	// [2] 모든 과목 목록 조회
	@GetMapping("/courses")
	public List<Course> showCourses() {
		return service.getAllCourses();
	}

	// [3] 학생 추가 (학생 이름 + 수강 과목 PK 함께 받음)
	@PostMapping("/students")
	public void addStudent(@RequestBody StudentRequestDto dto) { // fe에서 입력하는 값들을 요청Dto로 받음
		service.addStudent(dto.getName(), dto.getCourseIds());
	}

	// [4] 과목 추가 (과목명만 받음)

	@PostMapping("/courses")
	public void addCourse(@RequestBody Course course) {
		service.addCourse(course.getTitle());
	}

	// [5] 특정 학생 삭제
	@DeleteMapping("/students/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
	}

	// [6] 특정 과목 삭제
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable Long id) {
		service.deleteCourse(id);
	}

}
