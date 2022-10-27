package ua.alexshent.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.alexshent.crm.model.EmailAddress;
import ua.alexshent.crm.model.Employee;
import ua.alexshent.crm.model.Role;
import ua.alexshent.crm.model.User;
import ua.alexshent.crm.model.builder.AddressBuilder;
import ua.alexshent.crm.model.builder.EmailAddressBuilder;
import ua.alexshent.crm.model.builder.TelephoneNumberBuilder;
import ua.alexshent.crm.model.enumeration.*;
import ua.alexshent.crm.repository.*;
import ua.alexshent.crm.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class Seeder {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EmployeeStatusRepository employeeStatusRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    LeadSourceRepository leadSourceRepository;

    @Autowired
    LeadStatusRepository leadStatusRepository;

    @Autowired
    OpportunityTypeRepository opportunityTypeRepository;

    @Autowired
    IndustryRepository industryRepository;

    @Autowired
    SalesStageRepository salesStageRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EnumerationCache enumerationCache;

    @Autowired
    UserService userService;

    public void seed() {
        createEnumerations();
        enumerationCache.loadEnumerations();
        createEntities();
        createUsers();
    }

    private void createUsers() {
        Role roleUser = new Role();
        roleUser.setName("user");
        userService.saveRole(roleUser);

        Role roleManager = new Role();
        roleManager.setName("manager");
        userService.saveRole(roleManager);

        Role roleAdmin = new Role();
        roleAdmin.setName("admin");
        userService.saveRole(roleAdmin);

        User user = new User();
        user.setName("User 1");
        user.setUsername("user1");
        user.setPassword("1");
        List<Role> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setRoles(roles);
        userService.saveUser(user);

        User manager = new User();
        manager.setName("Manager 1");
        manager.setUsername("manager1");
        manager.setPassword("1");
        roles.clear();
        roles.add(roleUser);
        roles.add(roleManager);
        manager.setRoles(roles);
        userService.saveUser(manager);

        User admin = new User();
        admin.setName("Admin 1");
        admin.setUsername("admin1");
        admin.setPassword("1");
        roles.clear();
        roles.add(roleUser);
        roles.add(roleManager);
        roles.add(roleAdmin);
        admin.setRoles(roles);
        userService.saveUser(admin);
    }

    private void createEntities() {
        TelephoneNumberBuilder telephoneNumberBuilder = new TelephoneNumberBuilder();
        EmailAddressBuilder emailAddressBuilder = new EmailAddressBuilder();
        AddressBuilder addressBuilder = new AddressBuilder();

        // create boss

        Employee bossEmployee = new Employee();
        bossEmployee.setFirstName("Босс");
        bossEmployee.setLastName("Большой");
        bossEmployee.setJobTitle("умывальников начальник и мочалок командир");
        bossEmployee.setDepartment(enumerationCache.getDepartments().get("Department 1"));
        bossEmployee.setNotes("очень солидный дядька");
        bossEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("Active"));

        telephoneNumberBuilder.withNumber("12345");
        bossEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("123450");
        bossEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("big.boss@mycompany.com");
        bossEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 12")
                .withPostalCode("03037");
        bossEmployee.setPrimaryAddress(addressBuilder.build());

        employeeRepository.save(bossEmployee);

        // create worker that reports to the boss

        Employee workerEmployee = new Employee();
        workerEmployee.setFirstName("Лох");
        workerEmployee.setLastName("Большой");
        workerEmployee.setJobTitle("умывальников работник и сортиров лучший друг");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 1"));
        workerEmployee.setNotes("лошара");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("On Leave"));

        telephoneNumberBuilder.withNumber("000888");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("000999");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("big.loh@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        List<EmailAddress> emailAddresses = new ArrayList<>();
        emailAddressBuilder.withEmail("a@mycompany.com");
        emailAddresses.add(emailAddressBuilder.build());
        emailAddressBuilder.withEmail("b@mycompany.com");
        emailAddresses.add(emailAddressBuilder.build());
        emailAddressBuilder.withEmail("c@mycompany.com");
        emailAddresses.add(emailAddressBuilder.build());
        workerEmployee.setAlternateEmails(emailAddresses);

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 12")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);

        // ---------------------

        workerEmployee = new Employee();
        workerEmployee.setFirstName("Adam");
        workerEmployee.setLastName("Pakovski");
        workerEmployee.setJobTitle("Cleaning services worker");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 1"));
        workerEmployee.setNotes("Notes about Adam");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("Active"));

        telephoneNumberBuilder.withNumber("0008881");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("0009992");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("adam@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 12")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);

        // ------------------

        workerEmployee = new Employee();
        workerEmployee.setFirstName("Felix");
        workerEmployee.setLastName("Bimbo");
        workerEmployee.setJobTitle("переворачиватель пингвинов");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 2"));
        workerEmployee.setNotes(":))");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("Active"));

        telephoneNumberBuilder.withNumber("0007771");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("0005552");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("felix@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 12")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);

        // ------------------------

        workerEmployee = new Employee();
        workerEmployee.setFirstName("Raj");
        workerEmployee.setLastName("Kumar");
        workerEmployee.setJobTitle("Designer");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 3"));
        workerEmployee.setNotes("Praesent semper orci id mollis scelerisque. Quisque venenatis felis eu euismod tempor. Nunc orci magna, porta et risus et, tempor sollicitudin purus. In tempor lacinia tortor, ut porttitor enim convallis in. Sed et leo sagittis, maximus turpis vitae, posuere ligula. Fusce aliquam faucibus lacus eget accumsan. Mauris eget commodo nisl.");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("On Leave"));

        telephoneNumberBuilder.withNumber("111333777");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("74748347636");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("kumar@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 12")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);

        // ------------------------

        workerEmployee = new Employee();
        workerEmployee.setFirstName("Anton");
        workerEmployee.setLastName("Borodin");
        workerEmployee.setJobTitle("Writer");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 2"));
        workerEmployee.setNotes("Praesent semper orci id mollis scelerisque.");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("On Leave"));

        telephoneNumberBuilder.withNumber("844747475");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("755686944");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("anton@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 13")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);

        // ------------------------

        workerEmployee = new Employee();
        workerEmployee.setFirstName("Joanna");
        workerEmployee.setLastName("Smith");
        workerEmployee.setJobTitle("Doctor");
        workerEmployee.setDepartment(enumerationCache.getDepartments().get("Department 1"));
        workerEmployee.setNotes(":)");
        workerEmployee.setStatus(enumerationCache.getEmployeeStatuses().get("Active"));

        telephoneNumberBuilder.withNumber("1234567");
        workerEmployee.setOfficePhone(telephoneNumberBuilder.build());

        telephoneNumberBuilder.withNumber("876654333");
        workerEmployee.setMobilePhone(telephoneNumberBuilder.build());

        emailAddressBuilder.withEmail("joanna@mycompany.com");
        workerEmployee.setPrimaryEmail(emailAddressBuilder.build());

        addressBuilder.withCountry("Ukraine").withState("Kyiv").withCity("Kyiv").withStreet("Azovska street, 15")
                .withPostalCode("03037");
        workerEmployee.setPrimaryAddress(addressBuilder.build());

        workerEmployee.setReportsTo(bossEmployee);

        employeeRepository.save(workerEmployee);
    }

    void createEnumerations() {
        createEmployeeStatuses();
        createDepartments();
        createAccountTypes();
        createLeadSources();
        createOpportunityTypes();
        createLeadStatuses();
        createIndustries();
        createSalesStages();
    }

    void createDepartments() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM Department e").getSingleResult();
        if (count > 0) {
            return;
        }

        Department department = new Department();
        department.setName("Department 1");
        departmentRepository.save(department);

        department = new Department();
        department.setName("Department 2");
        departmentRepository.save(department);

        department = new Department();
        department.setName("Department 3");
        departmentRepository.save(department);
    }

    void createEmployeeStatuses() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM EmployeeStatus e").getSingleResult();
        if (count > 0) {
            return;
        }

        EmployeeStatus employeeStatus = new EmployeeStatus();
        employeeStatus.setName("Active");
        employeeStatusRepository.save(employeeStatus);

        employeeStatus = new EmployeeStatus();
        employeeStatus.setName("Dismissed");
        employeeStatusRepository.save(employeeStatus);

        employeeStatus = new EmployeeStatus();
        employeeStatus.setName("On Leave");
        employeeStatusRepository.save(employeeStatus);
    }

    void createAccountTypes() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM AccountType e").getSingleResult();
        if (count > 0) {
            return;
        }

        AccountType accountType = new AccountType();
        accountType.setName("Analyst");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Competitor");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Customer");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Integrator");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Investor");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Partner");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Press");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Prospect");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Reseller");
        accountTypeRepository.save(accountType);

        accountType = new AccountType();
        accountType.setName("Other");
        accountTypeRepository.save(accountType);
    }

    void createLeadSources() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM LeadSource e").getSingleResult();
        if (count > 0) {
            return;
        }

        LeadSource leadSource = new LeadSource();
        leadSource.setName("Cold Call");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Existing Customer");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Self Generated");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Employee");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Partner");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Public Relations");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Direct Mail");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Conference");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Trade Show");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Web Site");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Word Of Mouth");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Email");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Campaign");
        leadSourceRepository.save(leadSource);

        leadSource = new LeadSource();
        leadSource.setName("Other");
        leadSourceRepository.save(leadSource);
    }

    void createOpportunityTypes() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM OpportunityType e").getSingleResult();
        if (count > 0) {
            return;
        }

        OpportunityType opportunityType = new OpportunityType();
        opportunityType.setName("Existing Business");
        opportunityTypeRepository.save(opportunityType);

        opportunityType = new OpportunityType();
        opportunityType.setName("New Business");
        opportunityTypeRepository.save(opportunityType);
    }

    void createLeadStatuses() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM LeadStatus e").getSingleResult();
        if (count > 0) {
            return;
        }

        LeadStatus leadStatus = new LeadStatus();
        leadStatus.setName("New");
        leadStatusRepository.save(leadStatus);

        leadStatus = new LeadStatus();
        leadStatus.setName("Assigned");
        leadStatusRepository.save(leadStatus);

        leadStatus = new LeadStatus();
        leadStatus.setName("In Process");
        leadStatusRepository.save(leadStatus);

        leadStatus = new LeadStatus();
        leadStatus.setName("Converted");
        leadStatusRepository.save(leadStatus);

        leadStatus = new LeadStatus();
        leadStatus.setName("Recycled");
        leadStatusRepository.save(leadStatus);

        leadStatus = new LeadStatus();
        leadStatus.setName("Dead");
        leadStatusRepository.save(leadStatus);
    }

    void createIndustries() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM Industry e").getSingleResult();
        if (count > 0) {
            return;
        }

        Industry industry = new Industry();
        industry.setName("Apparel");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Banking");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Biotechnology");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Chemicals");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Communications");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Construction");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Consulting");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Education");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Electronics");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Energy");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Engineering");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Entertainment");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Environmental");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Finance");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Government");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Healthcare");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Hospitality");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Insurance");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Machinery");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Manufacturing");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Media");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Not For Profit");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Recreation");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Retail");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Shipping");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Technology");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Telecommunications");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Transportation");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Utilities");
        industryRepository.save(industry);

        industry = new Industry();
        industry.setName("Other");
        industryRepository.save(industry);
    }

    void createSalesStages() {
        long count = (long) entityManager.createQuery("SELECT COUNT(e) FROM SalesStage e").getSingleResult();
        if (count > 0) {
            return;
        }

        SalesStage salesStage = new SalesStage();
        salesStage.setName("Prospecting");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Qualification");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Needs Analysis");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Value Proposition");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Identifying Decision Makers");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Perception Analysis");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Proposal/Price Quote");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Negotiation/Review");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Closed Won");
        salesStageRepository.save(salesStage);

        salesStage = new SalesStage();
        salesStage.setName("Closed Lost");
        salesStageRepository.save(salesStage);
    }
}
