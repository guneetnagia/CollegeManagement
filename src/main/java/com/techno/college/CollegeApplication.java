package com.techno.college;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.techno.college.model.Course;
import com.techno.college.model.Department;
import com.techno.college.model.Instructor;
import com.techno.college.model.Student;
import com.techno.college.repository.CourseRepository;
import com.techno.college.repository.DepartmentRepository;
import com.techno.college.repository.InstructorRepository;
import com.techno.college.repository.StudentRepository;

@SpringBootApplication
public class CollegeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(CollegeApplication.class, args);
		CourseRepository courseRepository = applicationContext.getBean(CourseRepository.class);
		StudentRepository studentRepository = applicationContext.getBean(StudentRepository.class);
		InstructorRepository instructorRepository = applicationContext.getBean(InstructorRepository.class);
		DepartmentRepository departmentRepository = applicationContext.getBean(DepartmentRepository.class);
		
		Student goku = new Student("goku", "siayan", "9999999999");
		Student gohan = new Student("gohan", "siayan", "888888888");
		Student vegita = new Student("vegita", "siayan", "7777777777");
		Student piccolo = new Student("piccolo", "namek", "666666666");
		Student krilin = new Student("krilin", "earth", "555555555");
		
		
		Course java = new Course(1, "Java");
		Course react = new Course(2, "React");
		Course tom = new Course(3, "TOM");
		
		Instructor i1 = new Instructor("Prof. James", "James", "John", "1111111111");
		
		Department ComputerScience = new Department("Computer Science", "Pune");
		Department Mechanical = new Department("Mechanical", "Pune");
		
		Set<Student> students = new HashSet<>();
		students.add(goku);students.add(gohan);students.add(vegita);students.add(piccolo);students.add(krilin);

		
		Set<Course> couses = new HashSet<>();
		couses.add(java);couses.add(react);couses.add(tom);
		
		Set<Instructor> instructors = new HashSet<>();
		instructors.add(i1);
		
		Set<Department> department = new HashSet<>();
		department.add(ComputerScience); department.add(Mechanical);
		
		java.addStudents(goku);
		java.addStudents(gohan);
		java.addStudents(piccolo);
		react.addStudents(krilin);
		tom.addStudents(vegita);

		i1.addCourses(java);
		i1.addCourses(react);
		i1.addCourses(tom);
		
		ComputerScience.addCourse(java);
		ComputerScience.addCourse(react);	
		
		Mechanical.addCourse(tom);
		
		ComputerScience.addInstructor(i1);
		
		studentRepository.saveAll(students);
		
		courseRepository.saveAll(couses);
		
		instructorRepository.saveAll(instructors);
		
		departmentRepository.saveAll(department);
	}

}
