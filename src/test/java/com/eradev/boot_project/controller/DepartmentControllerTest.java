package com.eradev.boot_project.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.eradev.boot_project.entity.Department;
import com.eradev.boot_project.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private DepartmentService departmentService;

        private Department department;

        @BeforeEach
        void setUp() {
                department = Department.builder()
                                .departmentName("Dev Team")
                                .departmentAddress("Seoul")
                                .departmentCode("001")
                                .departmentId(1L)
                                .build();
        }

        @Test
        void testFetchDepartmentById() throws Exception {
                Mockito.when(departmentService.fetchDepartmentById(1L))
                                .thenReturn(department);

                mockMvc.perform(MockMvcRequestBuilders.get("/departments")
                                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().isOk());
        }

        @Test
        void testSaveDepartment() throws Exception {
                Department inputDepartment = Department.builder()
                                .departmentName("Dev Team")
                                .departmentAddress("Seoul")
                                .departmentCode("001")
                                .build();

                Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);
                mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                                "\t\"departmentName\":\"Dev Team\",\n" +
                                                "\t\"departmentAddress\":\"Seoul\",\n" +
                                                "\t\"departmentCode\":\"001\"\n" +
                                                "}"))
                                .andExpect(MockMvcResultMatchers.status().isOk());

        }
}
