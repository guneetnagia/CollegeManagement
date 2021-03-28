package com.techno.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.college.model.Department;
import com.techno.college.repository.DepartmentRepository;

@Service
public class DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department addDepartment(Department department){
		return departmentRepository.save(department);
	}
	
	public List<Department> findAll(){
		return departmentRepository.findAll();
	}
	
	public Department findByName(String deptName){
		return departmentRepository.findByName(deptName);
	}
	
	public void deleteDepartment(String deptName){
		departmentRepository.deleteByName(deptName);
	}
	
	public Department updateDepartment(Department department){
		Department dept= departmentRepository.findByName(department.getName());
		dept.setLocation(department.getLocation());
		dept.setName(department.getName());
		return departmentRepository.save(dept);
	}
}
