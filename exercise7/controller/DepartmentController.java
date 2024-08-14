package com.employee.EmployeeManagementSystem.controller;

import com.employee.EmployeeManagementSystem.model.Department;
import com.employee.EmployeeManagementSystem.repository.DepartmentRepository;
import com.employee.EmployeeManagementSystem.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

   
    @GetMapping("/search")
    public Page<Department> searchDepartments(
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sort", defaultValue = "id,asc") String sort) {

        String[] sortParams = sort.split(",");
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]));
        return departmentService.getDepartments(name, pageable);
    }

    // Endpoint to get a department by name
    @GetMapping("/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return departmentService.getDepartmentByName(name);
    }
}