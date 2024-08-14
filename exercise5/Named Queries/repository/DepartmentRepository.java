package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(name = "Department.findByName")
    Department findDepartmentByName(String name);
}
