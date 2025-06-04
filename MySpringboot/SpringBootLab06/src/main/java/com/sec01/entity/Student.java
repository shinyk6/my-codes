package com.sec01.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Student { 
 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
 
    private String name; 
 
    //나(Student)는 student_id로 중간 테이블에 연결됐어 joinColumns
    //나와 연결된 Course는 course_id로 연결됐어 inverseJoinColumns
    @ManyToMany 
    @JoinTable( //student_course를 joinTable로 만듦 (중간 테이블이 있던 없던 만듦)
        name = "student_course", //중간테이블 이름
        joinColumns = @JoinColumn(name = "student_id"),  // 현재 클래스= Student 외래키
        inverseJoinColumns = @JoinColumn(name = "course_id")  //반대 클래스= Course 외래키
    ) 
    @ToString.Exclude // 루프를 돌기에 빼줌
    private List<Course> courses = new ArrayList<>(); //객체 생성 하지 않으면 선언만 한 상태이기에 null상태로 빙글빙글 돎
} 