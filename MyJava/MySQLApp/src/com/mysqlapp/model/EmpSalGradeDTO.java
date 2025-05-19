package com.mysqlapp.model;

public record EmpSalGradeDTO(
			String ename, //접근제한자X 
			double sal,
			int grade
) {}
