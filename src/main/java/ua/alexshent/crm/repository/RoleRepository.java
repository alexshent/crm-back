package ua.alexshent.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.alexshent.crm.model.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Role findByName(String name);
}
