package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(name = "Employee.findByName")
    List<Employee> findEmployeesByName(String name);

    @Query(name = "Employee.findByEmail")
    Employee findEmployeeByEmail(String email);
}

