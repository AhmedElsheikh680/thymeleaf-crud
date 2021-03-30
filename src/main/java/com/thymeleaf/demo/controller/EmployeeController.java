package com.thymeleaf.demo.controller;

import com.thymeleaf.demo.model.Employee;
import com.thymeleaf.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping({"","/employees"})
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model model){
       List<Employee> emps =  employeeService.findAll();
       model.addAttribute("employees", emps);
       return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee emp = new Employee();
        model.addAttribute("employee", emp);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee emp){
        employeeService.save(emp);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
       Employee emp =  employeeService.findById(id);
       model.addAttribute("employee", emp);
       return "/employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }






































}
