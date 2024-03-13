package pro.sky.employee.controller;

import pro.sky.employee.domain.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.exception.EmployeeAlreadyAddedException;
import pro.sky.employee.exception.EmployeeNotFoundException;
import pro.sky.employee.exception.EmployeeStorageIsFullException;
import pro.sky.employee.service.EmployeeService;

import java.util.List;
import java.util.SortedMap;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.addEmployee(employee);
        } catch (EmployeeStorageIsFullException e) {
            return e.getMessage();
        } catch (EmployeeAlreadyAddedException e) {
            return e.getMessage();
        }
        return "Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " добавлен";
    }

    @GetMapping(path = "/employee/remove")
    public String deleteEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee((firstName), lastName);
        try {
            employeeService.deleteEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return "Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " удален";
    }

    @GetMapping(path = "/employee/find")
    public String searchEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            employeeService.searchEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        return "Сотрудник " + employee.getFirstName() + " " + employee.getLastName() + " найден";
    }

    @GetMapping(path = "/employee")
    public List<Employee> showAllEmployees() {
        return employeeService.showAllEmployees();
    }

}
