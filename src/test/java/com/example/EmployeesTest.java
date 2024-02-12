package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdoubles.BankServiceSpy;
import testdoubles.EmployeeRepositoryStub;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeesTest {

    private Employees employees;
    private EmployeeRepository employeeRepository;
    private BankService bankService;

    @BeforeEach
    public void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        bankService = mock(BankService.class);
        employees = new Employees(employeeRepository, bankService);
    }

    @Test
    @DisplayName("test pay employess with sucessful payment using mockito")
    public void testPayEmployeesSuccessfulPaymentUsingMockito() {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee("1", 1000));
        mockEmployees.add(new Employee("2", 2000));
        when(employeeRepository.findAll()).thenReturn(mockEmployees);


        int payments = employees.payEmployees();
        assertThat(payments).isEqualTo(2);
    }
    @Test
    @DisplayName("test pay employess with sucessful payment using testdoubles")
    public void testPayEmployeesSuccessfulPaymentUsingTestDoubles() {
        EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub();
        BankServiceSpy bankServiceSpy = new BankServiceSpy();
        Employees employees = new Employees(employeeRepositoryStub, bankServiceSpy);

        int payments = employees.payEmployees();

        assertTrue(bankServiceSpy.isPayMethodCalled());
    }

    @Test
    @DisplayName("failed payment using mockito")
    public void testPayEmployeesFailedPaymentUsingMockito() {
        List<Employee> mockEmployees = new ArrayList<>();
        mockEmployees.add(new Employee("1", 1000));
        mockEmployees.add(new Employee("2", 2000));
        when(employeeRepository.findAll()).thenReturn(mockEmployees);
        doThrow(new RuntimeException()).when(bankService).pay(anyString(), anyDouble());

        int payments = employees.payEmployees();
        assertThat(payments).isEqualTo(0);
    }
    @Test
    @DisplayName("failed payment using testdoubles")
    public void testPayEmployeesFailedPaymentUsingTestDoubles() {
        EmployeeRepositoryStub employeeRepositoryStub = new EmployeeRepositoryStub();
        BankServiceSpy bankServiceSpy = new BankServiceSpy();
        bankServiceSpy.setThrowException(true);
        Employees employees = new Employees(employeeRepositoryStub, bankServiceSpy);

        int payments = employees.payEmployees();
        Assertions.assertEquals(0, payments);
    }
}