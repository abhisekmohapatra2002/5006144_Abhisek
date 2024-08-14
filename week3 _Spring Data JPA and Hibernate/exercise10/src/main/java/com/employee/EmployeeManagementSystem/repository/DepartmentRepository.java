package com.employee.EmployeeManagementSystem.repository;

import com.employee.EmployeeManagementSystem.dto.DepartmentDTO;
import com.employee.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT new com.example.employeemanagementsystem.dto.DepartmentDTO(d.id, d.name) FROM Department d")
    List<DepartmentDTO> findDepartmentDTOs();
}
