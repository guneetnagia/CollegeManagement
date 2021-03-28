package com.techno.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.college.model.Course;
import com.techno.college.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping("listStudents/{studentId}")
	public List<Course> getCoursesForStudentId(@PathVariable("studentId") int studentId){
		return courseRepository.getCoursesByStudentId(studentId);
	} 
}
