package com.danielbobes.utils;

public final class StringUtils {

    private StringUtils() {

    }

    public static String capitalize(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }

}
