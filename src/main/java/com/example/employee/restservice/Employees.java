package com.example.employee.restservice;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    
    private List<Employee> employeesList;

    public List<Employee> getEmployeesList(){
        if(employeesList == null){
            employeesList =  new ArrayList<>();
        }
        return employeesList;
    }

    public void setEmployeesList(List<Employee> employeesList){
        this.employeesList = employeesList;
    }
}
