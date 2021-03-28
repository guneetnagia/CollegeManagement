package com.techno.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techno.college.model.Course;

@Repository

public interface CourseRepository extends JpaRepository<Course, Integer>{
	@Query("select c "
			+ " from Course c join c.students_list s"
			+ " where s.id =:studentId")
	public List<Course> getCoursesByStudentId(@Param("studentId") int studentId);
	
	public void deleteByName(String name);
}