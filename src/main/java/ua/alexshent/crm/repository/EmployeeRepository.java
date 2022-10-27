package ua.alexshent.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.alexshent.crm.model.Employee;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
