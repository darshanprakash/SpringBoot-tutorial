package com.darshan.springbootmicroservice.service;

import com.darshan.springbootmicroservice.entity.Department;
import com.darshan.springbootmicroservice.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String departmentName);
}
