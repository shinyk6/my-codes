package com.sec01.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

//[3] FE로 학생+과목 정보 응답용

@Data
@AllArgsConstructor
public class StudentResponseDto {
	
	private Long id;
	private String name;
	private List<CourseDto> courses;
}
