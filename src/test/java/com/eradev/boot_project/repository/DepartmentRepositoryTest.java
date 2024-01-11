package com.eradev.boot_project.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.eradev.boot_project.entity.Department;

@DataJpaTest
public class DepartmentRepositoryTest {
        @Autowired
        private DepartmentRepository departmentRepository;

        @Autowired
        private TestEntityManager entityManager;

        @BeforeEach
        void setUp() {
                Department department = Department.builder()
                                .departmentName("Sales Team")
                                .departmentCode("003")
                                .departmentAddress("Busan")
                                .build();

                entityManager.persist(department);
        }

        @Test
        @DisplayName("Return Department Name when ID is matched")
        public void whenFindById_thenReturnDepartment() {
                Department department = departmentRepository.findById(1L).get();
                assertEquals(department.getDepartmentName(), "Sales Team");
        }
}
