package com.danielbobes.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final String pattern = "MM/dd/yyyy";

    private DateUtils() {

    }

    public static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String formatDate(LocalDate date) {
        return formatDate(date, pattern);
    }

}
