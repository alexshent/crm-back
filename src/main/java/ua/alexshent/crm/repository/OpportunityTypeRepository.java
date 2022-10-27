package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.OpportunityType;

import java.util.UUID;

public interface OpportunityTypeRepository extends CrudRepository<OpportunityType, UUID> {
}
