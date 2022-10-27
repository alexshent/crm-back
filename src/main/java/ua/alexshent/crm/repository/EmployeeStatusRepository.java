package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.EmployeeStatus;

import java.util.UUID;

public interface EmployeeStatusRepository extends CrudRepository<EmployeeStatus, UUID> {
}
