package com.thymeleaf.demo.service;

import com.thymeleaf.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
}
