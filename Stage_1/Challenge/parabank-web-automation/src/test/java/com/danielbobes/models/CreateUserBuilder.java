package com.danielbobes.models;

public final class CreateUserBuilder {

    private final User user;

    private CreateUserBuilder() {
        user = new User();
    }

    public static CreateUserBuilder aUser() {
        return new CreateUserBuilder();
    }

    public CreateUserBuilder withPersonalInfo(String firstName, String lastName, String phone) {
        user.setFistName(firstName);
        user.setLastName(lastName);
        user.setPhone(phone);
        return this;
    }

    public CreateUserBuilder withAddress(String address, String city, String state, String zipCode) {
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setZipCode(zipCode);
        return this;
    }

    public CreateUserBuilder withSocialSecurityNumber(String socialSecurityNumber) {
        user.setSocialSecurityNumber(socialSecurityNumber);
        return this;
    }

    public CreateUserBuilder withCredentials(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        return this;
    }

    public User build() {
        return user;
    }
}
