package com.student.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.demo.entity.Student;
import com.student.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

//	@Autowired
	private StudentRepository repo;
	
	// Wiring/Injecting it manually using constructor
	public StudentServiceImpl(StudentRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = repo.findAll();
		return students;
	}

	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		repo.deleteById(id);
	}
	
}
