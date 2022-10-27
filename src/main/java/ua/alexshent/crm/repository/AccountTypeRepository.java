package ua.alexshent.crm.repository;

import org.springframework.data.repository.CrudRepository;
import ua.alexshent.crm.model.enumeration.AccountType;

import java.util.UUID;

public interface AccountTypeRepository extends CrudRepository<AccountType, UUID> {
}
