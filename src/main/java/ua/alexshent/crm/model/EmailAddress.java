package ua.alexshent.crm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class EmailAddress {
    @Id
    @GeneratedValue
    private UUID id;
    private String email;
    private boolean optOut;
    private boolean invalid;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isOptOut() {
        return optOut;
    }

    public void setOptOut(boolean optOut) {
        this.optOut = optOut;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }
}
