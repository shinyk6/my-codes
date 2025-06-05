package com.sec01.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

//[2] 새 학생 추가 시, 이름(name)과 과목 PK 리스트(courseId)를 전달받는 요청
@Data
@AllArgsConstructor
public class StudentRequestDto {
	
	private String name;
	private List<Long> courseIds;
}
