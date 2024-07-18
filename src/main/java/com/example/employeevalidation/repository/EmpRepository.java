package com.example.employeevalidation.repository;


import com.example.employeevalidation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee,Long> {
}