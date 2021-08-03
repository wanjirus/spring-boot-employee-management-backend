package net.stanleymburu.employeemanagementbackend.controller;

import net.stanleymburu.employeemanagementbackend.model.employee;
import net.stanleymburu.employeemanagementbackend.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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
    //create employee rest API
    @PostMapping("/employees")
    public  employee createEmployee(@RequestBody employee Employee){
        return employeeRepository.save(Employee);
    }

}
