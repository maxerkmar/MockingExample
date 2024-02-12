package testdoubles;

import java.util.ArrayList;
import java.util.List;

import com.example.Employee;
import com.example.EmployeeRepository;

public class EmployeeRepositoryStub implements EmployeeRepository {

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", 1000));
        employees.add(new Employee("2", 2000));
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        return e;
    }
}
