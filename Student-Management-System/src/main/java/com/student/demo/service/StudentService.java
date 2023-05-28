package com.student.demo.service;

import java.util.List;

import com.student.demo.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student saveStudent(Student student);
}
