package net.stanleymburu.employeemanagementbackend.controller;

import net.stanleymburu.employeemanagementbackend.exception.ResourceNotFoundException;
import net.stanleymburu.employeemanagementbackend.model.employee;
import net.stanleymburu.employeemanagementbackend.repository.employeeRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class employeeController {
    @Autowired
    private employeeRepository employeeRepository;

    //get all employees
    @GetMapping("/employees")
    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    //create employee rest API
    @PostMapping("/employees")
    public employee createEmployee(@RequestBody employee Employee) {
        return employeeRepository.save(Employee);
    }

  //Get Employee By ID
    @GetMapping("employees/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id){
        employee Employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
    return  ResponseEntity.ok(Employee);
    }

    



}


