package ua.alexshent.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alexshent.crm.controller.EntitiesPage;
import ua.alexshent.crm.model.Employee;
import ua.alexshent.crm.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService implements EntityService<Employee> {

    @Autowired
    private Environment environment;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee entity) {
        employeeRepository.save(entity);
        return entity;
    }

    @Override
    public Optional<Employee> read(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EntitiesPage<Employee> readPage(int pageNumber) {
        if (pageNumber <= 0) {
            throw new IllegalArgumentException("page number must be >= 1");
        }
        int pageSize = Integer.parseInt(environment.getProperty("ua.alexshent.crm.pageSize", "5"));
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by("created").descending());
        Page<Employee> page = employeeRepository.findAll(pageable);

        EntitiesPage<Employee> entitiesPage = new EntitiesPage<>();
        entitiesPage.setEntities(page.getContent());
        entitiesPage.setTotal(page.getTotalElements());
        return entitiesPage;
    }

    @Override
    public Employee update(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteById(List<UUID> ids) {
        employeeRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void delete(Employee entity) {
        employeeRepository.delete(entity);
    }

    @Override
    public void delete(List<Employee> entities) {
        employeeRepository.deleteAllInBatch(entities);
    }
}
