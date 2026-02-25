package com.danielbobes.web.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class Utils {

    private static final String SPANISH_DATE_PATTERN = "dd/MM/yyyy";

    private Utils() {

    }

    public static String getTomorrowsDate()  {
       return LocalDate.now()
               .plusDays(1)
               .format(DateTimeFormatter.ofPattern(SPANISH_DATE_PATTERN));
    }

}
