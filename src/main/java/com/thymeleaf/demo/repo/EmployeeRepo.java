package com.thymeleaf.demo.repo;

import com.thymeleaf.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    // Add Method To Sort By LastName
    public List<Employee> findAllByOrderByLastNameAsc();
}
