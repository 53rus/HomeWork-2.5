package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;

import java.util.HashMap;

public interface EmployeeService {

   void addEmployee(Employee employee) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException;

    void deleteEmployee(String employee) throws EmployeeNotFoundException;

    void searchEmployee(String employee) throws EmployeeNotFoundException;

    HashMap<String, Employee> showAllEmployees();
}
