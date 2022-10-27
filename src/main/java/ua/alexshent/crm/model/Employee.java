package ua.alexshent.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ua.alexshent.crm.controller.serializer.EmployeeSerializer;
import ua.alexshent.crm.model.embeddable.Address;
import ua.alexshent.crm.model.embeddable.TelephoneNumber;
import ua.alexshent.crm.model.enumeration.Department;
import ua.alexshent.crm.model.enumeration.EmployeeStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//@JsonSerialize(using = EmployeeSerializer.class)
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;

    private String lastName;

    private String jobTitle;

    @ManyToOne
    private Department department;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    private EmployeeStatus status;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "op_number"))
    @AttributeOverride(name = "invalid", column = @Column(name = "op_invalid"))
    private TelephoneNumber officePhone;

    @Embedded
    @AttributeOverride(name = "number", column = @Column(name = "mp_number"))
    @AttributeOverride(name = "invalid", column = @Column(name = "mp_invalid"))
    private TelephoneNumber mobilePhone;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private EmailAddress primaryEmail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<EmailAddress> alternateEmails;

    @Embedded
    @AttributeOverride(name = "country", column = @Column(name = "pa_country"))
    @AttributeOverride(name = "state", column = @Column(name = "pa_state"))
    @AttributeOverride(name = "city", column = @Column(name = "pa_city"))
    @AttributeOverride(name = "street", column = @Column(name = "pa_street"))
    @AttributeOverride(name = "postalCode", column = @Column(name = "pa_postal_code"))
    private Address primaryAddress;

    @ManyToOne
    private Employee reportsTo;

    @OneToMany(mappedBy = "reportsTo")
    @JsonIgnore
    private List<Employee> subordinates;

    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist
    public void onCreate() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updated = LocalDateTime.now();
    }

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

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public EmailAddress getPrimaryEmail() {
        return primaryEmail;
    }

    public void setPrimaryEmail(EmailAddress primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public List<EmailAddress> getAlternateEmails() {
        if (alternateEmails != null) {
            return alternateEmails;
        }
        return new ArrayList<>();
    }

    public void setAlternateEmails(List<EmailAddress> alternateEmails) {
        this.alternateEmails = alternateEmails;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }
}
