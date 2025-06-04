package com.sec01.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
public class Student { 
 
    @Id 
    @GeneratedValue 
    private Long id; 
 
    private String name; 
 
    @ManyToMany 
    @JoinTable( 
        name = "student_course", 
        joinColumns = @JoinColumn(name = "student_id"), 
        inverseJoinColumns = @JoinColumn(name = "course_id") 
    ) 
    private List<Course> courses; 
} 