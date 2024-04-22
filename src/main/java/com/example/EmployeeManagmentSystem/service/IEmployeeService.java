package com.example.EmployeeManagmentSystem.service;

import com.example.EmployeeManagmentSystem.dto.EmployeeDto;
import com.example.EmployeeManagmentSystem.entity.Employee;
import org.apache.el.stream.Optional;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
    List<Employee> getAllEmployees();
    Boolean removeEmployeeById(Long id);
    Boolean updateEmployeeById(Long id,EmployeeDto emp);
}
