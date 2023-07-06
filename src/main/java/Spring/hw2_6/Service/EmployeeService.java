package Spring.hw2_6.Service;

import Spring.hw2_6.Model.Employee;
import Spring.hw2_6.Exceptions.EmployeeAlreadyAddedException;
import Spring.hw2_6.Exceptions.EmployeeStorageIsFullException;
import Spring.hw2_6.Exceptions.EmployeeNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>();
    private final int MAX_SIZE_EMPLOYEES_LIST = 4;

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() == MAX_SIZE_EMPLOYEES_LIST) {
            throw new EmployeeStorageIsFullException("Список сотрудников переполнен.");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже в списке.");
        } else {
            employees.add(employee);
            return employee;
        }
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден в списке.");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден в списке.");
        }
    }

    public List<Employee> employeesList() {
        return new ArrayList<>(employees);
    }
}