package com.danielbobes.web.utils;

import com.danielbobes.web.config.Config;
import com.github.javafaker.Faker;

public final class DataFactory {

    private static final Faker faker = new Faker(Config.SPANISH_LOCALE);

    private DataFactory() {

    }

    public static String getUsername() {
        return faker.name().username();
    }

    public static String getPassword() {
        return faker.internet().password();
    }

}
