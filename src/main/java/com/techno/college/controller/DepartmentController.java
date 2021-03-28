package com.techno.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.college.model.Department;
import com.techno.college.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department addDepartment(@RequestBody Department department){
		return departmentService.addDepartment(department);
	}

	@GetMapping("/findAll")
	public List<Department> findAllDepartment(){
		return departmentService.findAll();
	}

	@GetMapping("/findOne/{deptName}")
	public Department findDepartmentByName(@PathVariable String deptName){
		return departmentService.findByName(deptName);
	}

	@DeleteMapping("/delete/{deptName}")
	public void deleteInstructor(@PathVariable String deptName){
		departmentService.deleteDepartment(deptName);
	}
	
	@PatchMapping("/update")
	public Department updateDepartment(@RequestBody Department department){
		return departmentService.updateDepartment(department);
	}
}
