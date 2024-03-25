package pro.sky.employee.service;

import pro.sky.employee.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Employee> maxSalaryDepartment(int department);

    Optional <Employee> minSalaryDepartment(int department);

    List<Employee> allEmployeesDepartment(int department);

    List <Employee> allEmployeesSortDepartment();

}
