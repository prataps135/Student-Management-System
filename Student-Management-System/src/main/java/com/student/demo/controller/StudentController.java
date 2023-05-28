package com.student.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.demo.entity.Student;
import com.student.demo.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;

	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(value="/students")
	public String listOfStudens(Model model) {
		model.addAttribute("students",service.getAllStudents());
		
		// returning students view
		return "students";
	}
	
	@GetMapping(value="/students/add")
	public String createStudentForm(Model model) {
		// create student object to hold new student data
		Student student = new Student();
		
		model.addAttribute("student",student);
		return "add_student";
	}
	
	@PostMapping(value="/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service
	}
}
