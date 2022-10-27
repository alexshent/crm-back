package ua.alexshent.crm.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Contact extends Individual {

    @ManyToOne
    private Contact reportsTo;

    private LocalDate birthday;

    private String assistantName;

    @OneToOne
    private TelephoneNumber assistantPhone;

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public Contact getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Contact reportsTo) {
        this.reportsTo = reportsTo;
    }

    public TelephoneNumber getAssistantPhone() {
        return assistantPhone;
    }

    public void setAssistantPhone(TelephoneNumber assistantPhone) {
        this.assistantPhone = assistantPhone;
    }
}
