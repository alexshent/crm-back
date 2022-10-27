package ua.alexshent.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.alexshent.crm.model.enumeration.Department;
import ua.alexshent.crm.model.enumeration.EmployeeStatus;
import ua.alexshent.crm.service.DepartmentService;
import ua.alexshent.crm.service.EmployeeStatusService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EnumerationController {

    static class Enumerations {
        private List<Department> departments;
        private List<EmployeeStatus> employeeStatuses;

        public List<Department> getDepartments() {
            return departments;
        }

        public void setDepartments(List<Department> departments) {
            this.departments = departments;
        }

        public List<EmployeeStatus> getEmployeeStatuses() {
            return employeeStatuses;
        }

        public void setEmployeeStatuses(List<EmployeeStatus> employeeStatuses) {
            this.employeeStatuses = employeeStatuses;
        }
    }

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeStatusService employeeStatusService;

    @GetMapping("/enumeration")
    public Enumerations getAll() {
        Enumerations enumerations = new Enumerations();
        enumerations.setDepartments(departmentService.getAll());
        enumerations.setEmployeeStatuses(employeeStatusService.getAll());
        return enumerations;
    }
}
