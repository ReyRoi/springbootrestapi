package com.SpringPro1.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.SpringPro1.restapi.entity.*;
import com.SpringPro1.restapi.repo.StudentRepo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StudentController {
	@Autowired
	StudentRepo repo;
	//get all the students
	//localhost:8080/students
	@GetMapping("/students")
	public List<Student> getAllStudentname(){
		List<Student> students = repo.findAll();
		return students;
	}
	
	//get student by id
	//localhost:8080/student/{id}
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student student = repo.findById(id).get();
		
		return student;
	}
	//create new student
	//localhost:8080/create
	@PostMapping("/students/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	@PutMapping("students/{id}")
	public Student updateStudentById(@PathVariable int id) {
		Student student = repo.findById(id).get();
		student.setAge(35);
		student.setName("The king");
		repo.save(student);
		return student;
	}
	@DeleteMapping("/students/{id}")
	public String deleteStudentById(@PathVariable int id) {
		Student student = repo.findById(id).get();
		repo.delete(student);
		return "Student data is deleted";
	}
	
	
	
}
