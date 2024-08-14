package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d WHERE d.name = ?1")
    Department findDepartmentByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:name%")
    List<Department> searchDepartmentsByName(String name);
}

