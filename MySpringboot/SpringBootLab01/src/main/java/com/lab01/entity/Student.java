package com.lab01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id // PK 등록 (id를 기본키로)
	@GeneratedValue(strategy=GenerationType.IDENTITY) //자동생성을 DB에 위임하겠다.
	private Long id;
	
	private String name;
	private int grade;
}
