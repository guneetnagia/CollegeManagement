package com.techno.college.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	@Column(name="department_name")
	private String name;
	@Column(name="location")
	private String location;
	
	@OneToMany(targetEntity=Instructor.class)
	@JoinColumn(name="department_name")
	private List<Instructor> instructors = new ArrayList<>();
	
	@OneToMany(targetEntity=Course.class)
	@JoinColumn(name="department_name")
	private List<Course> courses = new ArrayList<>();
	
	public void addInstructor(Instructor i){
		instructors.add(i);
	}
	
	public void addCourse(Course c){
		courses.add(c);
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Department(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Department() {
		super();
	}
	
	
}
