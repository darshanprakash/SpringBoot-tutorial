package com.darshan.springbootTutorial.service;

import com.darshan.springbootTutorial.entity.Department;
import com.darshan.springbootTutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
