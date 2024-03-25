package pro.sky.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employee.domain.Employee;
import pro.sky.employee.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping(path = "/departments/max-salary")
    public Optional<Employee> maxSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.maxSalaryDepartment(department);
    }

    @GetMapping(path = "/departments/min-salary")
    public Optional<Employee> minSalaryDepartment(@RequestParam("department") int department) {
        return departmentService.minSalaryDepartment(department);
    }

    @GetMapping(path = "/departments/all", params = {"department"})
    public List<Employee> allEmployeesDepartment(@RequestParam("department") int department) {
        return departmentService.allEmployeesDepartment(department);
    }

    @GetMapping(path = "/departments/all")
    public List<Employee> allEmployeesSortDepartment() {
        return departmentService.allEmployeesSortDepartment();

    }
}