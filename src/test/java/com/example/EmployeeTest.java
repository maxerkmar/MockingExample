package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    Employee employee = new Employee("123",30000);
    @Test
    @DisplayName("test constructors and getters")
    public void testConstructorsAndGetters() {
        assertEquals("123", employee.getId());
        assertEquals(30000, employee.getSalary());
        assertFalse(employee.isPaid());
    }

    @Test
    @DisplayName("test setters")
    public void testSetters() {
        employee.setId("456");
        employee.setSalary(40000);
        employee.setPaid(true);

        assertEquals("456", employee.getId());
        assertEquals(40000, employee.getSalary());
        assertTrue(employee.isPaid());
    }

    @Test
    @DisplayName("test tostring")
    public void testToString(){
        String result = employee.toString();

        assertTrue(result.contains("Employee"));
        assertTrue(result.contains("id=" + employee.getId()));
        assertTrue(result.contains("salary=" + employee.getSalary()));
    }
}