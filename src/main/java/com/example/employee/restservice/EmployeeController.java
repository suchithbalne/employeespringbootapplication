package com.example.employee.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    
    private EmployeeManager employeeManager;
    @Autowired
    public EmployeeController(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @GetMapping(path="/", produces="application/json")
    public Employees getEmployees(){
        return employeeManager.getAllEmployees();
    }

    @PostMapping(path="/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee){
        Integer id = employeeManager.getAllEmployees().getEmployeesList().size()+1;

        employee.setEmployeeId(id);

        employeeManager.addEmployee(employee);

        return ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getEmployeeId()).toUri()).build();

    }
}
