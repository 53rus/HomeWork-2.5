package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;

import java.util.List;
import java.util.SortedMap;

public interface EmployeeService {

    void addEmployee(Employee employee) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    void deleteEmployee(Employee employee) throws EmployeeNotFoundException;

    Employee searchEmployee(Employee employee) throws EmployeeNotFoundException;

    List<Employee> showAllEmployees();
}
