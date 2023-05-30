package com.student.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.student.demo.entity.Student;
import com.student.demo.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args){
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	StudentRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Student student1 = new Student("Pratap","Singh","pratap@gmail.com");
//		repo.save(student1);
//		
//		Student student2 = new Student("Sanjay","Singh","sanjay@gmail.com");
//		repo.save(student2);
//		
//		Student student3 = new Student("Tony","Stark","stark@gmail.com");
//		repo.save(student3);
	}

}
