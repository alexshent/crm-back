package ua.alexshent.crm.service;

import ua.alexshent.crm.controller.EntitiesPage;
import ua.alexshent.crm.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntityService<T> {

    T create(T entity);

    Optional<T> read(UUID id);

    EntitiesPage<Employee> readPage(int page);

    T update(T entity);

    void deleteById(UUID id);

    void deleteById(List<UUID> ids);

    void delete(T entity);

    void delete(List<T> entities);
}
