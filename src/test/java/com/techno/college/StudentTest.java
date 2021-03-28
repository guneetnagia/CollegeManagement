package com.techno.college;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.techno.college.exceptions.ResourceNotFoundException;
import com.techno.college.model.Student;
import com.techno.college.repository.StudentRepository;
import com.techno.college.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {
	
	@Autowired
	private StudentService studentService;

	@MockBean
	private StudentRepository studentRepository;
	
	private List<Student> students;
	
	@Before
	public void addStudents(){
		students = Stream.of(
				new Student("A1", "a2", "9090909090"),
				new Student("B1", "b2", "8080808080")
				).collect(Collectors.toList());
	}
	
	@Test
	public void getAllStudentsTest(){
		when(studentRepository.findAll()).thenReturn(students);
		assertEquals(2, studentService.findAll().size());
	}
	
	@Test(expected = ResourceNotFoundException.class)
	public void getStudentByIdTest(){
		when(studentRepository.findById(-100)).thenThrow(ResourceNotFoundException.class);
		studentService.findById(-100);
	}

	@Test
	public void addStudentTest(){
		Student stu = new Student("c1", "c2", "1");
		when(studentRepository.save(stu)).thenReturn(stu);
		assertEquals(stu, studentService.addStudent(stu));
	}
	
	@Test
	public void deleteStudentFNameTest(){
		Student stu = new Student("A1", "a2", "9090909090");
		studentService.deleteStudentByFname(stu.getFirstName());
		verify(studentRepository,times(1)).deleteByFirstName(stu.getFirstName());		
	}
	
	@Test
	public void updateStudentTest(){
		
	}
}
