package ua.alexshent.crm.model;

import ua.alexshent.crm.model.enumeration.LeadSource;
import ua.alexshent.crm.model.enumeration.OpportunityType;
import ua.alexshent.crm.model.enumeration.SalesStage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Opportunity {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private int amount;
    private LocalDate expectedCloseDate;
    private int probability;
    private String nextStep;
    private String description;

    @ManyToOne
    private Account account;

    @ManyToOne
    private SalesStage salesStage;

    @ManyToOne
    private OpportunityType type;

    @ManyToOne
    private LeadSource leadSource;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getExpectedCloseDate() {
        return expectedCloseDate;
    }

    public void setExpectedCloseDate(LocalDate expectedCloseDate) {
        this.expectedCloseDate = expectedCloseDate;
    }

    public int getProbability() {
        return probability;
    }

    public void setProbability(int probability) {
        this.probability = probability;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SalesStage getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(SalesStage salesStage) {
        this.salesStage = salesStage;
    }

    public OpportunityType getType() {
        return type;
    }

    public void setType(OpportunityType type) {
        this.type = type;
    }

    public LeadSource getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(LeadSource leadSource) {
        this.leadSource = leadSource;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }
}
