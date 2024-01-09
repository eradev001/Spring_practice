package com.eradev.boot_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eradev.boot_project.entity.Department;
import com.eradev.boot_project.service.DepartmentService;

@RestController
public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        @PostMapping("/departments")
        public Department saveDepartment(@RequestBody Department department) {

                return departmentService.saveDepartment(department);
        }

        @GetMapping("/departments")
        public List<Department> fetchDepartmentList() {
                return departmentService.fetchDepartmentList();
        }

        @GetMapping("/departments/{id}")
        public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
                return departmentService.fetchDepartmentById(departmentId);
        }

        @DeleteMapping("/departments/{id}")
        public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
                departmentService.deleteDepartmentById(departmentId);
                return "Department deleted succsessfully !!";
        }

        @PutMapping("/departments/{id}")
        public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
                // TODO: process PUT request
                return departmentService.updateDepartment(departmentId, department);
        }

        @GetMapping("/departments/name/{name}")
        public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
                return departmentService.fetchDepartmentByName(departmentName);
        }

}