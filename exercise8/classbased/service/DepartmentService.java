package com.employee.EmployeeManagementSystem.service;

import com.employee.EmployeeManagementSystem.model.Department;
import com.employee.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    
    public Page<Department> getDepartments(String name, Pageable pageable) {
        return departmentRepository.findByNameContaining(name, pageable);
    }

   
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }
}
