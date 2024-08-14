package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.dto.EmployeeDTO;
import com.employee.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email, e.department.name) FROM Employee e")
    List<EmployeeDTO> findEmployeeDTOs();
}
