package net.stanleymburu.employeemanagementbackend.controller;

import net.stanleymburu.employeemanagementbackend.exception.ResourceNotFoundException;
import net.stanleymburu.employeemanagementbackend.model.employee;
import net.stanleymburu.employeemanagementbackend.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    //update employee rest Api
    @PutMapping("/employees/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id,@RequestBody employee employeeDetails){
        employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee updateEmployee=employeeRepository.save(employee);
      return ResponseEntity.ok(updateEmployee);
    }
//delete employee rest Api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HashMap<String, Boolean>> deleteEmployee(@PathVariable Long id){
        employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id));
        employeeRepository.delete(employee);
        HashMap<String, Boolean> response=new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}


