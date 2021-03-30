package com.thymeleaf.demo.service;

import com.thymeleaf.demo.model.Employee;
import com.thymeleaf.demo.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepo.findById(id);

        Employee employee=null;
        if(result.isPresent()){
            employee = result.get();
        }else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void save(Employee emp) {
        employeeRepo.save(emp);
    }

    @Override
    public void deleteById(int id) {
        employeeRepo.deleteById(id);
    }
}
