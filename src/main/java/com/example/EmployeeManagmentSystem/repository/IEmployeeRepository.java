package com.example.EmployeeManagmentSystem.repository;

import com.example.EmployeeManagmentSystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

}
