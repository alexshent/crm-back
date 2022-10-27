package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.Department;

import java.util.UUID;

public interface DepartmentRepository extends CrudRepository<Department, UUID> {
}
