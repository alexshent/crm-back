package ua.alexshent.crm.model.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class TelephoneNumber {

    private String number;

    private boolean invalid;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }
}
