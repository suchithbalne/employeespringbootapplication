package com.example.employee.restservice;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
    
    private static Employees list = new Employees();

    static{
        list.getEmployeesList().add(
            new Employee(1, "Suchith", "Balne", "sb123@gmail.com", "Manager")
        );

        list.getEmployeesList().add(
            new Employee(2,"Srujan", "Thatipally", "sr123@gmail.com", "Developer"));

        list.getEmployeesList().add(
            new Employee(3,"Ashray", "Dundigalla", "ashray@gmail.com", "Tester")
        );
    }

    public Employees getAllEmployees(){
        return list;
    }

    public void addEmployee(Employee employee){
        list.getEmployeesList().add(employee);
    }
}
