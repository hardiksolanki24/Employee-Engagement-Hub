package com.example.EmployeeManagmentSystem.service.Impl;

import com.example.EmployeeManagmentSystem.dto.EmployeeDto;
import com.example.EmployeeManagmentSystem.entity.Employee;
import com.example.EmployeeManagmentSystem.exception.ResourceNotFoundException;
import com.example.EmployeeManagmentSystem.mapper.EmployeeMapper;
import com.example.EmployeeManagmentSystem.repository.IEmployeeRepository;
import com.example.EmployeeManagmentSystem.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee emp = employeeRepository.findById(id).orElseThrow( () ->new ResourceNotFoundException("Employee is not exist with given id : " + id));

        return EmployeeMapper.mapToEmployeeDto(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
//        List<EmployeeDto> employeeDtoList ;
//        for (Employee emp:employeeList){
//            EmployeeDto e = EmployeeMapper.mapToEmployeeDto(emp);
//            employeeDtoList.add(e);
//        }
        return employeeList;
    }

    @Override
    public Boolean removeEmployeeById(Long id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
