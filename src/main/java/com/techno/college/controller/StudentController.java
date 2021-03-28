package com.techno.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.college.model.Student;
import com.techno.college.service.StudentService;

@RestController
@RequestMapping("/student")


public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getByInstructor/{instructorId}")
	public List<Student> getStudentsforInstructor(@PathVariable int instructorId){
		return studentService.findByInstructor(instructorId);
	}
	
	@GetMapping("/hello")
	public String helloWorld(){
		return "hello world";
	}

	@PostMapping("/save")
	public Student addStudent(@RequestBody Student student){
		return studentService.addStudent(student); 
	}

	@GetMapping("/findAll")
	public List<Student> findAllStudents(){
		return studentService.findAll();
	}

	@GetMapping("/findOne/{studentId}")
	public Student findStudentById(@PathVariable int studentId){
		return studentService.findById(studentId);
	}

	@DeleteMapping("/delete/{student}")
	public void deleteStudent(@PathVariable int studentId){
		studentService.deleteStudent(studentId);
	}
	
	@DeleteMapping("/delete/{student_name}")
	public void deleteStudentByFName(@PathVariable String student_name){
		studentService.deleteStudentByFname(student_name);
	}
	
	@PatchMapping("/update")
	public Student updateStudent(@RequestBody Student student){
		return studentService.updateStudent(student);
	}
	
	
}
