package ua.alexshent.crm.model;

import ua.alexshent.crm.model.enumeration.AccountType;
import ua.alexshent.crm.model.enumeration.Industry;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String website;
    private String description;

    @OneToOne
    private EmailAddress primaryEmail;

    @OneToMany
    private List<EmailAddress> alternateEmails;

    @OneToOne
    private TelephoneNumber officePhone;

    @OneToOne
    private Address billingAddress;

    @OneToOne
    private Address shippingAddress;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int annualRevenue;

    @ManyToOne
    private AccountType type;

    @ManyToOne
    private Industry industry;

    private int headcount;

    @OneToMany
    private List<Contact> contacts;

    @ManyToOne
    private Employee assignedTo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public TelephoneNumber getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(TelephoneNumber officePhone) {
        this.officePhone = officePhone;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
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

    public int getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(int annualRevenue) {
        this.annualRevenue = annualRevenue;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getHeadcount() {
        return headcount;
    }

    public void setHeadcount(int headcount) {
        this.headcount = headcount;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }
}
