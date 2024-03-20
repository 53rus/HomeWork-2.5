package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int SIZE = 6;

    Map<String ,Employee> employeeList = new HashMap<>(Map.of(
            "Ivan Ivanov",
            new Employee(
                    "Ivan",
                    "Ivanov"),
            "Semen Semenov",
            new Employee(
                    "Semen",
                    "Semenov"),
            "Fedor Fedorov",
            new Employee(
                    "Fedor",
                    "Fedorov"),
            "Freddy Kruger",
            new Employee(
                    "Freddy",
                    "Kruger")
    ));

    @Override
    public void addEmployee(Employee employee) throws EmployeeAlreadyAddedException, EmployeeStorageIsFullException {
        if (employeeList.size() >= SIZE) {
            throw new EmployeeStorageIsFullException(
                    "Максимальное допустимое количество сотрудников " + SIZE +
                            ", " +
                            " Текущее количество сотрудников " + employeeList.size() +
                            ", " +
                            "Вы исчерпали лимит сотрудников");
        } else if (employeeList.containsKey(employee.getFirstName() + " " + employee.getLastName())) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            employeeList.put(employee.getFirstName() + " " + employee.getLastName(), employee);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employeeList.containsKey(employee.getFirstName() + " " + employee.getLastName())) {
            employeeList.remove(employee.getFirstName() + " " + employee.getLastName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public Employee searchEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employeeList.containsKey(employee.getFirstName() + " " + employee.getLastName())) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public HashMap<String, Employee> showAllEmployees() {
        return (HashMap<String, Employee>) employeeList;
    }
}
