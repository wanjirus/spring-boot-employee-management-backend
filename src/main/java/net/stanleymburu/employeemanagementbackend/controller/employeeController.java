package net.stanleymburu.employeemanagementbackend.controller;

import net.stanleymburu.employeemanagementbackend.model.employee;
import net.stanleymburu.employeemanagementbackend.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class employeeController {
    @Autowired
    private employeeRepository employeeRepository;
    //get all employees
    @GetMapping("/employees")
    public List<employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
}
