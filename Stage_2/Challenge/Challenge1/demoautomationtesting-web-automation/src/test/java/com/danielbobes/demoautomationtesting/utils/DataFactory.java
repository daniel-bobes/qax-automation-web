package com.danielbobes.demoautomationtesting.utils;

import com.github.javafaker.Faker;

import java.util.Optional;

public final class DataFactory {

    private static final Faker faker = new Faker();

    public DataFactory() {

    }

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getValidEmail() {
        return faker.internet().emailAddress();
    }

    public static String getPhone() {
        return faker.number().digits(10);
    }

    public static String getGender() {
        return faker.options().option("Male", "FeMale");
    }

    public static String getHobby() {
        return faker.options().option("Cricket", "Movies", "Hockey");
    }

    public static String getSkill() {
        return faker.options().option("Python", "Internet", "Engineering", "SQL");
    }

    public static String getCountry() {
        return faker.options().option("Australia", "India", "Denmark", "Hong Kong");
    }

    public static String getYear() {
        return faker.options().option("1975", "1983", "1992", "1995");
    }

    public static String getMonth() {
        return faker.options().option("January", "March", "April", "June");
    }

    public static String getDay() {
        return faker.options().option("1", "8", "15", "27");
    }

    public static String getPassword() {
        return faker.internet().password(8, 14, true, true, true);
    }

}
