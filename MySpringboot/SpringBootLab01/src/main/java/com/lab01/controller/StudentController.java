package com.lab01.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab01.entity.Student;
import com.lab01.service.StudentService;


@RestController //타임리프는 안만들겠다(?) 
@RequestMapping("/students")  //중복되는 url은 상단에 미리 선언하면 편함 
public class StudentController {

	@Autowired
	private StudentService studentService; //Service빈을 studentService필드에 주입
	
	/// 학생 목록 조회
//	@GetMapping
//	public List<Student> getAllStudent(){
//		return studentService.findAll();
//	}
	
	/// 학생 등록
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	/// 학생 상세 조회 GET  /students/{id}
//	@GetMapping("/{id}")
//	public Student getStudentById(@PathVariable Long id) { //path에 있는 변수로 값을 받음
//		return studentService.findById(id);
//	}
	
	/// 학생 정보 수정 PUT	/students/{id}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) { //수정정보를 JSON으로 받기에 @RequestBody
		Student res = studentService.findById(id); // 수정될 ID로 객체를 찾아옴
		res.setGrade(student.getGrade()); // 입력된 데이터를 담은 객체인 student의 grade와 name으로 대입
		res.setName(student.getName());
		
		return studentService.save(res); // 수정된 내용을 저장 후 리턴
	}
	
	/// 학생 상세 삭제 Delete /students/{id}
	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
	}
	
	/// 학생 목록 조회
	@GetMapping
    public CollectionModel<EntityModel<Student>> getAllStudents() {
        List<Student> students = studentService.findAll();

        // 추가 코드
        List<EntityModel<Student>> studentModels = students.stream()
        		.map(student -> EntityModel.of(student,
        				WebMvcLinkBuilder
                        .linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(student.getId()))
                        .withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
                        .withRel("all-students")))
                .collect(Collectors.toList());

        return CollectionModel.of(studentModels, WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withSelfRel());
    }
	
	
	/// 학생 상세조회
	@GetMapping("/{id}")
	public EntityModel<Student> getStudentById(@PathVariable Long id){
		Student student = studentService.findById(id);
		///추가 코드
		EntityModel<Student> resource = EntityModel.of(student);
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(id))
				.withSelfRel());
		
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
				.withRel("all-students"));
		
		return resource;
	}
}
