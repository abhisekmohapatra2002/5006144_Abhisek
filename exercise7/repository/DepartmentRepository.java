package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    
    Page<Department> findByNameContaining(String name, Pageable pageable);
    Department findByName(String name);
}