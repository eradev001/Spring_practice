package com.eradev.boot_project.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eradev.boot_project.entity.Department;
import com.eradev.boot_project.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {

        @Autowired
        private DepartmentService departmentService;

        @MockBean
        private DepartmentRepository departmentRepository;

        @BeforeEach
        void setUp() {
                Department department = Department.builder()
                                .departmentName("Dev Team")
                                .departmentAddress("Seoul")
                                .departmentCode("001")
                                .departmentId(1L)
                                .build();

                Mockito.when(departmentRepository.findByDepartmentName("Dev Team")).thenReturn(department);
        }

        @Test
        @DisplayName("Get the Data based on Valid Department Name")
        public void whenValidDepartmentName_thenDepartmentShouldFound() {
                String departmentName = "Dev Team";
                Department found = departmentService.fetchDepartmentByName(departmentName);
                assertEquals(departmentName, found.getDepartmentName());

        }
}
