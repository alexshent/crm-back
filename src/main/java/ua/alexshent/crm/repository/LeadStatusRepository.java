package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.LeadStatus;

import java.util.UUID;

public interface LeadStatusRepository extends CrudRepository<LeadStatus, UUID> {
}
