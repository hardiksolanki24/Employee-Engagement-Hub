package com.example.EmployeeManagmentSystem.controller;

import com.example.EmployeeManagmentSystem.dto.EmployeeDto;
import com.example.EmployeeManagmentSystem.entity.Employee;
import com.example.EmployeeManagmentSystem.service.IEmployeeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/api/employees")
public class EmployeeController {

    private IEmployeeService employeeService;

    @PostMapping("/AddEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employeeDtoList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(Long id){
        EmployeeDto emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp,HttpStatus.OK);
    }

    @DeleteMapping("/removeEmployeeById/{id}")
    public ResponseEntity<Boolean> removeEmployeeById(Long id){
        Boolean isDeleted = employeeService.removeEmployeeById(id);
        return new ResponseEntity<>(isDeleted,HttpStatus.OK);
    }

    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<Boolean> updateEmployeeById(Long id,@RequestBody EmployeeDto UpdatedemployeeDto){
        Boolean isUpdated = employeeService.updateEmployeeById(id,UpdatedemployeeDto);
        return new ResponseEntity<>(isUpdated,HttpStatus.ACCEPTED);
    }

}

