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

import com.techno.college.model.Instructor;
import com.techno.college.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	private InstructorService instructorService;
	
	@PostMapping("/save")
	public Instructor addInstructor(@RequestBody Instructor instructor){
		return instructorService.addInstructor(instructor);
	}

	@GetMapping("/findAll")
	public List<Instructor> findAllInstructor(){
		return instructorService.findAll();
	}

	@GetMapping("/findOne/{instructorId}")
	public Instructor findStudentById(@PathVariable int instructorId){
		return instructorService.findById(instructorId);
	}

	@DeleteMapping("/delete/{instructor}")
	public void deleteInstructor(@PathVariable int instructorId){
		instructorService.deleteInstructor(instructorId);
	}
	
	@DeleteMapping("/delete/{instructor_name}")
	public void deleteInstructorByFName(@PathVariable String instructor_name){
		instructorService.deleteInstructorByFname(instructor_name);
	}
	
	@PatchMapping("/update")
	public Instructor updateInstructor(@RequestBody Instructor instructor){
		return instructorService.updateInstructor(instructor);
	}
}
