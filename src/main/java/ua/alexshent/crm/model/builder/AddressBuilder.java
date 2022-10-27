package ua.alexshent.crm.model.builder;

import ua.alexshent.crm.model.embeddable.Address;

public class AddressBuilder {
    private String country;
    private String state;
    private String city;
    private String street;
    private String postalCode;

    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public AddressBuilder withState(String state) {
        this.state = state;
        return this;
    }

    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder withStreet(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public Address build() {
        Address address = new Address();
        address.setCountry(country);
        address.setState(state);
        address.setCity(city);
        address.setStreet(street);
        address.setPostalCode(postalCode);
        return address;
    }
}
