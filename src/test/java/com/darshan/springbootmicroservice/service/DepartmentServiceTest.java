package com.darshan.springbootmicroservice.service;

import com.darshan.springbootmicroservice.entity.Department;
import com.darshan.springbootmicroservice.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("ECE")
                .departmentCode("EC-01")
                .departmentAddress("Bengaluru")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("ECE")).thenReturn(department);
    }

    @Test
    @DisplayName(value = "Getting data based on valid department name")
    public void whenValidDepartment_thenDepartmentShouldFound() {
        String departmentName = "ECE";
        Department foundDepartment = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}