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
		return studentRepository.saveAndFlush(null);
	}
	
	public Student findById(Long id) { //특정 ID의 Student를 조회
		return studentRepository.findById(null).orElse(null);
	}
	
	public void delete(Long id) { //특정 ID의 Student를 삭제
		studentRepository.deleteById(id);
	}
	
}
