package com.techno.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.college.exceptions.ResourceNotFoundException;
import com.techno.college.model.Instructor;
import com.techno.college.model.Student;
import com.techno.college.repository.InstructorRepository;

@Service
public class InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;
	
	public Instructor addInstructor(Instructor instructor){
		return instructorRepository.save(instructor);
	}
	
	public List<Instructor> findAll(){
		return instructorRepository.findAll();
	}
	
	public Instructor findById(int instructorId){
		return instructorRepository.findById(instructorId)
		.orElseThrow(ResourceNotFoundException::new);
	}
	
	public void deleteInstructor(int instructorId){
		instructorRepository.deleteById(instructorId);
	}
	
	public void deleteInstructorByFname(String name){
		instructorRepository.deleteByFirstName(name);
	}
	
	public Instructor updateInstructor(Instructor instructor){
		Instructor ins = instructorRepository.findById(instructor.getId()).orElseThrow(ResourceNotFoundException::new);
		ins.setFirstName(instructor.getFirstName());
		ins.setLastName(instructor.getLastName());
		ins.setHeadedBy(instructor.getHeadedBy());
		ins.setPhone(instructor.getPhone());
		return instructorRepository.save(ins);
	}
}
