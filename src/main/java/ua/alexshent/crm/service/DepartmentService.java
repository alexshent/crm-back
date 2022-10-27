package ua.alexshent.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alexshent.crm.model.enumeration.Department;
import ua.alexshent.crm.repository.DepartmentRepository;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    @Transactional
    public List<Department> getAll() {
        return (List<Department>) repository.findAll();
    }
}
