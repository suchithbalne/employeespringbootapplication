package com.example.employee.restservice;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

class EmployeeControllerTest {

    private MockMvc mockMvc;

    private EmployeeManager employeeManager;
    private EmployeeController employeeController;

    @BeforeEach
    void setUp() {
        employeeManager = mock(EmployeeManager.class);
        employeeController = new EmployeeController(employeeManager);
        Employees employees = new Employees();
        employees.setEmployeesList(new ArrayList<>());

        when(employeeManager.getAllEmployees()).thenReturn(new Employees());

    }

    @Test
    void testGetEmployees() {
        Employees employees = new Employees();
        when(employeeManager.getAllEmployees()).thenReturn(employees);

        Employees result = employeeController.getEmployees();

        assertEquals(employees, result);
        verify(employeeManager, times(1)).getAllEmployees();
    }

    @Test
    void testAddEmployee() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        Employee employee = new Employee();
        employee.setEmployeeId(1);
    
        Employees employees = new Employees();
        employees.setEmployeesList(new ArrayList<>());
    
        when(employeeManager.getAllEmployees()).thenReturn(employees);
        doNothing().when(employeeManager).addEmployee(employee);
    
        ResponseEntity<Object> result = employeeController.addEmployee(employee);
    
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        verify(employeeManager, times(1)).addEmployee(employee);
    }
    
}
