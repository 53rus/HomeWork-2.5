package pro.sky.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.employee.domain.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Optional<Employee> maxSalaryDepartment(int department) {
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public Optional <Employee> minSalaryDepartment(int department){
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary));
    }

    @Override
    public List<Employee> allEmployeesDepartment(int department) {
        return employeeService.showAllEmployees().values().stream()
                .filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());

    }

    @Override
    public List <Employee> allEmployeesSortDepartment() {
        return employeeService.showAllEmployees().values().stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
