package com.techno.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.college.exceptions.ResourceNotFoundException;
import com.techno.college.model.Course;
import com.techno.college.model.Student;
import com.techno.college.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public Course addCourse(Course course){
		return courseRepository.save(course);
	}
	
	public List<Course> findAll(){
		return courseRepository.findAll();
	}
	
	public Course findById(int courseId){
		return courseRepository.findById(courseId)
		.orElseThrow(ResourceNotFoundException::new);
	}
	
	public void deleteCourse(int courseId){
		courseRepository.deleteById(courseId);
	}
	
	public void deleteCourseByname(String name){
		courseRepository.deleteByName(name);
	}
	
	public Course updateCourse(Course course){
		Course c= courseRepository.findById(course.getId()).orElseThrow(ResourceNotFoundException::new);
		c.setDuration(course.getDuration());
		c.setName(course.getName());
		return courseRepository.save(c);
	}
}