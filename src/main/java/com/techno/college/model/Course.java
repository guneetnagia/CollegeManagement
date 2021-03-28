package com.techno.college.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	//@Column(name="course_id")
	private int id;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany()
	@JoinTable(name="course_student",
		joinColumns={@JoinColumn(name="course_id")},
		inverseJoinColumns={@JoinColumn(name="student_id")}
			)
	private Set<Student> students_list = new HashSet<Student>();
	
	public void addStudents(Student stu){
		students_list.add(stu);
	}

	public Course(int duration, String name) {
		super();
		this.duration = duration;
		this.name = name;
	}

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public int getDuration() {
		return duration;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
