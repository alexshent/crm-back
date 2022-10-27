package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.SalesStage;

import java.util.UUID;

public interface SalesStageRepository extends CrudRepository<SalesStage, UUID> {
}
