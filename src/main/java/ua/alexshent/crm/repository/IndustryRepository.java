package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.Industry;

import java.util.UUID;

public interface IndustryRepository extends CrudRepository<Industry, UUID> {
}
