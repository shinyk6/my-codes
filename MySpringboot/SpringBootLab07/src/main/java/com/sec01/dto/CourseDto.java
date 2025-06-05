package com.sec01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//[1] 과목 정보(id, title) 응답용

@Data
@AllArgsConstructor
public class CourseDto {

	private Long id;
	private String title;
	
}
