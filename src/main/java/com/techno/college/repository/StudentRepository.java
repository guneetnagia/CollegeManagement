package com.techno.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techno.college.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	public void deleteByFirstName(String name);
	
	//select s.* from instructor i 
	//join course c on c.instructor_id = i.id 
	//join course_student cs on cs.course_id = c.id 
	//join student s on s.student_id = cs.student_id

	@Query("select s from Instructor i "
			+ " join i.courses c"
			+ " join c.students_list s"
			+ " where i.id=:instructorId")
	public List<Student> getStudentsByInstructorId(@Param("instructorId") int instructorId);
}
