package com.danielbobes.web.challenges.parabank.data.factory;

import com.danielbobes.web.challenges.parabank.models.CreateUserBuilder;
import com.danielbobes.web.challenges.parabank.models.User;
import com.github.javafaker.Faker;

import java.util.Locale;

public final class CreateUserDataFactory {

    private static final Faker faker = new Faker(Locale.forLanguageTag("es"));;

    private CreateUserDataFactory() {
    }

    public static User withAllInformation(){
        return CreateUserBuilder
                .aUser()
                .withPersonalInfo(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        faker.phoneNumber().phoneNumber())
                .withAddress(
                        faker.address().streetAddress(),
                        faker.address().cityName(),
                        faker.address().state(),
                        faker.address().zipCode())
                .withSocialSecurityNumber(faker.numerify("#".repeat(9)))
                .withCredentials(
                        faker.name().username(),
                        faker.internet().password())
                .build();
    }
}
