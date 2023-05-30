package com.student.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping(value="/students/update/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "update_student";
	}
	
	@PostMapping(value="students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		// get student from db by id 
		Student existingStudent = service.getStudentById(id);
		
		// update the student
		existingStudent.setId(student.getId());
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		// save updated student object
		service.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@GetMapping(value="/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}
}
