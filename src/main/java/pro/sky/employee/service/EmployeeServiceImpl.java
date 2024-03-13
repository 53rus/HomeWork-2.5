package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final int SIZE = 6;

    List<Employee> employeeList = new ArrayList<>(List.of(
            new Employee("Ivan", "Ivanov"),
            new Employee("Semen", "Semenov"),
            new Employee("Fedor", "Fedorov"),
            new Employee("Freddy", "Kruger")
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
        } else if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        } else {
            employeeList.add(employee);
        }
    }

    @Override
    public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public Employee searchEmployee(Employee employee) throws EmployeeNotFoundException {
        if (employeeList.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public List<Employee> showAllEmployees() {
        return employeeList;
    }
}
