package com.example.employee.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeesTest {

    private Employees employees;

    @BeforeEach
    public void setUp() {
        employees = new Employees();
    }

    @Test
    public void testGetEmployeesList() {
        List<Employee> employeesList = employees.getEmployeesList();
        assertNotNull(employeesList);
        assertTrue(employeesList.isEmpty());
    }

    @Test
    public void testSetEmployeesList() {
        Employee employee = new Employee(1, "Alice", "Johnson", "alice@example.com", "Manager");
        employees.setEmployeesList(List.of(employee));
        assertEquals(1, employees.getEmployeesList().size());
        assertSame(employee, employees.getEmployeesList().get(0));
    }
}
