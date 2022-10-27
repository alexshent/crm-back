package ua.alexshent.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.alexshent.crm.model.Employee;
import ua.alexshent.crm.service.EmployeeService;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public EntitiesPage<Employee> getPage(@RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        return employeeService.readPage(pageNumber);
    }

    @PostMapping("/employee")
    public void create(@RequestBody Employee employee) {
        employeeService.create(employee);
    }

    @DeleteMapping("/employee")
    public void delete(@RequestBody List<UUID> ids) {
        employeeService.deleteById(ids);
    }
}
