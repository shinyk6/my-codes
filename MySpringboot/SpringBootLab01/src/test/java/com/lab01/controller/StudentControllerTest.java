package com.lab01.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab01.entity.Student;

@SpringBootTest //Test클래스
@AutoConfigureMockMvc //springBoot MVC를 테스트하겠다.
public class StudentControllerTest {
	
	@Autowired
	MockMvc mockMvc; //가상객체
	
	//Json 형태 변환용
	@Autowired
	private ObjectMapper mapper;
	
	private Student student;
	//테스트 이전에 하나의 레코드를 insert 해보자.
	@BeforeEach
	void setUp() {
		student = new Student();
		student.setGrade(6);
		student.setName("8888");
	}
	
	/*
	 * 	1) 학생 등록 테스트
	 * 		(POST /students)
	 */
	@Test
	void createStudent() throws Exception{
		

//		 mockMvc.perform(post("/students")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(mapper)))
//				.andExpect(status().isCreated()) //201 Created, isOk() 200 사용해도됨
//				.andExpect(jsonPath("$.name").value(student.getName()))
//				.andExpect(jsonPath("$.grade").value(student.getGrade()));
		 String newStudentJson = "{ \"name\": \"홍길동\", \"grade\": 1 }"; 
		 mockMvc.perform(post("/students")
					.contentType(MediaType.APPLICATION_JSON)
					.content(newStudentJson))
					.andExpect(status().isOk()) //201 Created, isOk() 200 
					.andExpect(jsonPath("$.name").value("홍길동"))
					.andExpect(jsonPath("$.grade").value(1));
	}
	
	/*
	 * 	2) 학생 목록 테스트
	 * 
	 */		
	@Test
	void getAll() throws Exception {
		 mockMvc.perform(get("/students"))
					.andExpect(status().isOk());
	}
}
