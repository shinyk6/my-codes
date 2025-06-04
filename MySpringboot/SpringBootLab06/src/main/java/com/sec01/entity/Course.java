package com.sec01.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor  //Course(Long, String, List<Student)
@AllArgsConstructor 
public class Course { 
 
    @Id 
    @GeneratedValue 
    private Long id; 
 
    private String title; 
 
    @ManyToMany(mappedBy = "courses") 
    private List<Student> students; 
} 