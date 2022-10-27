package ua.alexshent.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alexshent.crm.model.enumeration.*;
import ua.alexshent.crm.repository.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EnumerationCache {
    Map<String, EmployeeStatus> employeeStatuses;
    Map<String, AccountType> accountTypes;
    Map<String, LeadSource> leadSources;
    Map<String, LeadStatus> leadStatuses;
    Map<String, Industry> industries;
    Map<String, SalesStage> salesStages;
    Map<String, OpportunityType> opportunityTypes;
    Map<String, Department> departments;

    @Autowired
    EmployeeStatusRepository employeeStatusRepository;
    @Autowired
    AccountTypeRepository accountTypeRepository;
    @Autowired
    LeadSourceRepository leadSourceRepository;
    @Autowired
    LeadStatusRepository leadStatusRepository;
    @Autowired
    IndustryRepository industryRepository;
    @Autowired
    SalesStageRepository salesStageRepository;
    @Autowired
    OpportunityTypeRepository opportunityTypeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    public void loadEnumerations() {

        employeeStatuses = new HashMap<>();
        accountTypes = new HashMap<>();
        leadSources = new HashMap<>();
        leadStatuses = new HashMap<>();
        industries = new HashMap<>();
        salesStages = new HashMap<>();
        opportunityTypes = new HashMap<>();
        departments = new HashMap<>();

        List<EmployeeStatus> listEmployeeStatus = (List<EmployeeStatus>) employeeStatusRepository.findAll();
        listEmployeeStatus.forEach(es -> employeeStatuses.put(es.getName(), es));

        List<AccountType> listAccountType = (List<AccountType>) accountTypeRepository.findAll();
        listAccountType.forEach(entity -> accountTypes.put(entity.getName(), entity));

        List<LeadSource> listLeadSource = (List<LeadSource>) leadSourceRepository.findAll();
        listLeadSource.forEach(entity -> leadSources.put(entity.getName(), entity));

        List<LeadStatus> listLeadStatus = (List<LeadStatus>) leadStatusRepository.findAll();
        listLeadStatus.forEach(entity -> leadStatuses.put(entity.getName(), entity));

        List<Industry> listIndustry = (List<Industry>) industryRepository.findAll();
        listIndustry.forEach(entity -> industries.put(entity.getName(), entity));

        List<SalesStage> listSalesStage = (List<SalesStage>) salesStageRepository.findAll();
        listSalesStage.forEach(entity -> salesStages.put(entity.getName(), entity));

        List<OpportunityType> listOpportunityType = (List<OpportunityType>) opportunityTypeRepository.findAll();
        listOpportunityType.forEach(entity -> opportunityTypes.put(entity.getName(), entity));

        List<Department> listDepartment = (List<Department>) departmentRepository.findAll();
        listDepartment.forEach(entity -> departments.put(entity.getName(), entity));
    }

    public Map<String, EmployeeStatus> getEmployeeStatuses() {
        return employeeStatuses;
    }

    public Map<String, AccountType> getAccountTypes() {
        return accountTypes;
    }

    public Map<String, LeadSource> getLeadSources() {
        return leadSources;
    }

    public Map<String, LeadStatus> getLeadStatuses() {
        return leadStatuses;
    }

    public Map<String, Industry> getIndustries() {
        return industries;
    }

    public Map<String, SalesStage> getSalesStages() {
        return salesStages;
    }

    public Map<String, OpportunityType> getOpportunityTypes() {
        return opportunityTypes;
    }

    public Map<String, Department> getDepartments() {
        return departments;
    }
}
