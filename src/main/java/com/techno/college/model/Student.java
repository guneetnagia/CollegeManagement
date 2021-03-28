package com.techno.college.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="student_fname")
	private String firstName;
	@Column(name="student_lname")
	private String lastName;
	@Column(name="student_ph_no")
	private String phone;
	
	@ManyToMany(mappedBy="students_list")
	private Set<Course> courses = new HashSet<>();
	
	public void addCourse(Course c){
		courses.add(c);
	}

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public int getID() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
