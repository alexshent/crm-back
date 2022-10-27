package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.LeadSource;

import java.util.UUID;

public interface LeadSourceRepository extends CrudRepository<LeadSource, UUID> {
}
