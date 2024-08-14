package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByDepartmentName(String departmentName);


    Employee findByEmail(String email);

    boolean existsByEmail(String email);

    
    List<Employee> findByNameContaining(String keyword);
}
