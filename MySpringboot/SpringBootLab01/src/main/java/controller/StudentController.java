package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


@RestController 
@RequestMapping("/students")  //중복되는 url은 상단에 미리 선언하면 편함 
public class StudentController {

	private StudentService studentService;
	
	List<Student> getAllStudent(){
		return null;
	}
	
	Student createStudent(Student student) {
		return null;
	}
	
	/// 학생 상세 조회 GET  /students/{id}
	@GetMapping("/{id}")
	Student getStudentById(@PathVariable Long id) { //path에 있는 변수로 값을 받음
		return null;
	}
	
	/// 학생 정보 수정 PUT	/students/{id}
	@PutMapping("/{id}")
	Student updateStudent(@PathVariable Long id, @RequestBody Student student) { //수정정보를 JSON으로 받기에 @RequestBody
		return null;
	}
	
	/// 학생 상세 삭제 Delete /students/{id}
	@DeleteMapping("/{id}")
	void deleteStudent(@PathVariable Long id) {
		
	}
	
}
