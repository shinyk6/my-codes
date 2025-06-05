package com.sec01.dto;

import java.util.List;

import com.sec01.entity.Course;

import lombok.AllArgsConstructor;
import lombok.Data;

//[4] 학생 목록과 전체 과목 목록을 한번에 FE 리턴

@Data
@AllArgsConstructor
public class StudentsAndCoursesResponse {

	private List<StudentResponseDto> students;
	private List<Course> courses;
}
