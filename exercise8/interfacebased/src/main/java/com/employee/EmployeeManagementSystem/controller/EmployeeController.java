package com.employee.EmployeeManagementSystem.controller;

import com.employee.EmployeeManagementSystem.model.Employee;
import com.employee.EmployeeManagementSystem.repository.EmployeeRepository;
import com.employee.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    @GetMapping("/search")
    public Page<Employee> searchEmployeesByName(
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sort", defaultValue = "id,asc") String sort) {

        String[] sortParams = sort.split(",");
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]));
        return employeeService.getEmployeesByName(name, pageable);
    }

    // Endpoint for paginated and sorted employee search by department name
    @GetMapping("/search/department")
    public Page<Employee> searchEmployeesByDepartment(
        @RequestParam(value = "departmentName", defaultValue = "") String departmentName,
        @RequestParam(value = "page", defaultValue = "0") int page,
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sort", defaultValue = "id,asc") String sort) {

        String[] sortParams = sort.split(",");
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortParams[1]), sortParams[0]));
        return employeeService.getEmployeesByDepartment(departmentName, pageable);
    }
}
