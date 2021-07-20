package com.darshan.springbootTutorial.controller;

import com.darshan.springbootTutorial.entity.Department;
import com.darshan.springbootTutorial.error.DepartmentNotFoundException;
import com.darshan.springbootTutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save department of Department controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("department")
    public List<Department> getDepartments() {
        LOGGER.info("Inside get departments of department controller");
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }
}
