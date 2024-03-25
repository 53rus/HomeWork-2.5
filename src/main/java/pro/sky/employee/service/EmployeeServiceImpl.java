package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int SIZE = 10;

    HashMap<String, Employee> employeeList = new HashMap<>(Map.of(
            "Ivan Ivanov",
            new Employee(
                    "Ivan",
                    "Ivanov",
                    1,
                    10_000),
            "Semen Semenov",
            new Employee(
                    "Semen",
                    "Semenov",
                    1,
                    11_000),
            "Fedor Fedorov",
            new Employee(
                    "Fedor",
                    "Fedorov",
                    2,
                    20_000),
            "Freddy Kruger",
            new Employee(
                    "Freddy",
                    "Kruger",
                    2,
                    21_000),
            "Anton Antonov",
            new Employee(
                    "Anton",
                    "Antonov",
                    1,
                    30_000),
            "Leonid Leonidov",
            new Employee(
                    "Leonid",
                    "Leonidov",
                    3,
                    31_000)

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
    public void deleteEmployee(String employee) throws EmployeeNotFoundException {
        if (employeeList.containsKey(employee)) {
            employeeList.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public void searchEmployee(String employee) throws EmployeeNotFoundException {
        if (employeeList.containsKey(employee)) {
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public HashMap<String, Employee> showAllEmployees() {
        return employeeList;
    }
}
