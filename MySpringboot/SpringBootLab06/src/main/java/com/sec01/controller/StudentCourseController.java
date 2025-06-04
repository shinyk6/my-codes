package com.sec01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.sec01.entity.Course;
import com.sec01.entity.Student;
import com.sec01.service.StudentCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentCourseController {

	@Autowired
	StudentCourseService service;
	
	@GetMapping("/students")
	public String showStudents(Model model) {
		List<Student> students = service.getAllStudents();
		List<Course> courses = service.getAllCourses();
		
		model.addAttribute("students", students);
		model.addAttribute("courses", courses);
		return "students";
	}
	
	@GetMapping("/courses")
	public String showCourses(Model model) {
		List<Course> courses = service.getAllCourses();
		model.addAttribute("courses",courses);
		
		return "courses";
	}
	
	@PostMapping("/students")
	public String addStudent(@RequestParam String studentName, @RequestParam String courseTitle) {
		service.addStudent(studentName, courseTitle);
		
		return "redirect:/students";
	}
	
	@PostMapping("/courses")
	public String addCourse(@RequestParam String courseTitle) {
		service.addCourse(courseTitle);
		
		return "redirect:/courses";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		
		return "redirect:/students";
	}
	
	@GetMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable Long id) {
		service.deleteCourse(id);
		
		return "redirect:/courses";
	}
	
}
