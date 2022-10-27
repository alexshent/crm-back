package ua.alexshent.crm.model;

import ua.alexshent.crm.model.enumeration.LeadSource;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public abstract class Individual {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String jobTitle;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;

    @OneToOne
    private TelephoneNumber officePhone;

    @OneToOne
    private TelephoneNumber mobilePhone;

    @OneToOne
    private EmailAddress primaryEmail;

    @OneToMany
    private List<EmailAddress> alternateEmails;

    @ManyToOne
    private Account account;

    @OneToOne
    private Address primaryAddress;

    @OneToOne
    private Address alternateAddress;

    @ManyToOne
    private Employee assignedTo;

    @ManyToOne
    private LeadSource leadSource;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelephoneNumber getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(TelephoneNumber officePhone) {
        this.officePhone = officePhone;
    }

    public TelephoneNumber getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(TelephoneNumber mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public EmailAddress getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(EmailAddress primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public List<EmailAddress> getAlternateEmails() {
        return alternateEmails;
    }

    public void setAlternateEmails(List<EmailAddress> alternateEmails) {
        this.alternateEmails = alternateEmails;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public Address getAlternateAddress() {
        return alternateAddress;
    }

    public void setAlternateAddress(Address alternateAddress) {
        this.alternateAddress = alternateAddress;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(LeadSource leadSource) {
        this.leadSource = leadSource;
    }
}
