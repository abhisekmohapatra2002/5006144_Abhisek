package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    
    Page<Employee> findByNameContaining(String name, Pageable pageable);

   
    Page<Employee> findByDepartmentNameContaining(String departmentName, Pageable pageable);
}

