package ua.alexshent.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.alexshent.crm.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
