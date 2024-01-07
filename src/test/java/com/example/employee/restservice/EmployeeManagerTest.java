package com.example.employee.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    public void testGetAllEmployees() {
        Employees employees = employeeManager.getAllEmployees();
        assertNotNull(employees);
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(5, "Bob", "Brown", "bob@example.com", "Developer");
        employeeManager.addEmployee(employee);
        assertEquals(4, employeeManager.getAllEmployees().getEmployeesList().size());
        assertSame(employee, employeeManager.getAllEmployees().getEmployeesList().get(3));
    }
}
