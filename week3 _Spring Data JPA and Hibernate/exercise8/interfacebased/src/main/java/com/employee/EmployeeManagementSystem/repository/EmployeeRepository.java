package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Employee;
import com.employee.EmployeeManagementSystem.projection.EmployeeProjection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email, e.department.name AS departmentName FROM Employee e")
    List<EmployeeProjection> findEmployeeProjections();
}