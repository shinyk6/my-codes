package com.sec01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//학생명 + 수강명 - 특정 필드만 사용할 때
@AllArgsConstructor
public @Data class StudentCourseDto {
	
	private String studentName;
	private String courseTitle;
	
	public StudentCourseDto(){}; // Projection.fields 사용하기 위해 기본생성자 필수
	
}
