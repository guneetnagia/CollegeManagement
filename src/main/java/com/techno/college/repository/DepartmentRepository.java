package com.techno.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techno.college.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	public Department findByName(String deptName);
	public void deleteByName(String deptName);
}
