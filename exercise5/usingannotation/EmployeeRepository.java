package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findEmployeeByEmail(String email);

    @Query("SELECT e FROM Employee e WHERE e.department.name = ?1")
    List<Employee> findEmployeesByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchEmployeesByName(String name);
}
