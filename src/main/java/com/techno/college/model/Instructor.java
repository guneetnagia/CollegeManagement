package com.techno.college.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="headed_by")
	private String headedBy;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="phone")
	private String phone;
	
	@OneToMany(targetEntity=Course.class)
	@JoinColumn(name="instructor_id")
	private List<Course> courses = new ArrayList<>();
	
	public void addCourses(Course c){
		courses.add(c);
	}
	
	public int getId() {
		return id;
	}
	public String getHeadedBy() {
		return headedBy;
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
	public void setHeadedBy(String headedBy) {
		this.headedBy = headedBy;
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
	public Instructor(String headedBy, String firstName, String lastName, String phone) {
		super();
		this.headedBy = headedBy;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	public Instructor() {
		super();
	}
	
	
}
