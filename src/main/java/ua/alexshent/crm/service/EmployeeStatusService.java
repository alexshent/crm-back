package ua.alexshent.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.alexshent.crm.model.enumeration.EmployeeStatus;
import ua.alexshent.crm.repository.EmployeeStatusRepository;

import java.util.List;

@Service
public class EmployeeStatusService {

    @Autowired
    EmployeeStatusRepository repository;

    @Transactional
    public List<EmployeeStatus> getAll() {
        return (List<EmployeeStatus>) repository.findAll();
    }
}
