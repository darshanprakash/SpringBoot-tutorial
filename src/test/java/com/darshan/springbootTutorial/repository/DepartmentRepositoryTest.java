package com.darshan.springbootTutorial.repository;

import com.darshan.springbootTutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical")
                .departmentCode("ME-02")
                .departmentAddress("Bengaluru")
                .build();
        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department foundDepartment = departmentRepository.findById(1L).get();
        assertEquals(foundDepartment.getDepartmentName(), "Mechanical");
    }
}