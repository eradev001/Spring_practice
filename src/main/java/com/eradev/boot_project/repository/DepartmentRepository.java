package com.eradev.boot_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eradev.boot_project.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

        public Department findByDepartmentName(String departmentName);
}