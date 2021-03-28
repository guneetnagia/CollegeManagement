package com.techno.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.college.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer>{
	public void deleteByFirstName(String name);
}
