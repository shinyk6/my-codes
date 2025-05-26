package com.lab01.service;


import com.lab01.entity.Student;
import com.lab01.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll(){ //저장된 모든 Student데이터를 조회
		return studentRepository.findAll();
	}
	
	public Student save(Student student) { //새로운 Student를 저장하거나 기존 데이터를 수정
		return studentRepository.saveAndFlush(student);
	}
	
	public Student findById(Long id) { //특정 ID의 Student를 조회
		return studentRepository.findById(id).orElse(null); //null 대신 Optional클래스를 사용
				//orElse(null) : Optional객체가 null인 경우 null이 반환되지만, orElse내부의 연산은 항상 실행됨
	}
	
	public void delete(Long id) { //특정 ID의 Student를 삭제
		studentRepository.deleteById(id);
	}
	
}
