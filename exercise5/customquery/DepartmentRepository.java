package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

   
    Department findByName(String name);

 
    List<Department> findByNameContaining(String keyword);
}

