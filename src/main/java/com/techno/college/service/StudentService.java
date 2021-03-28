package com.techno.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.college.exceptions.ResourceNotFoundException;
import com.techno.college.model.Student;
import com.techno.college.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findByInstructor(int instructorId){
		return studentRepository.getStudentsByInstructorId(instructorId);
	} 
	
	public Student addStudent(Student student){
		return studentRepository.save(student);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
	
	public Student findById(int studentId){
		return studentRepository.findById(studentId)
		.orElseThrow(ResourceNotFoundException::new);
	}
	
	public void deleteStudent(int studentId){
		studentRepository.deleteById(studentId);
	}
	
	public void deleteStudentByFname(String name){
		studentRepository.deleteByFirstName(name);
	}
	
	public Student updateStudent(Student student){
		Student stu = studentRepository.findById(student.getID()).orElseThrow(ResourceNotFoundException::new);
		stu.setFirstName(student.getFirstName());
		stu.setLastName(student.getLastName());
		stu.setPhone(student.getPhone());
		return studentRepository.save(stu);
	}
}
