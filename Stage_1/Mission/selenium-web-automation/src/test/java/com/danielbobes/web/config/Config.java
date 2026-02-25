package com.danielbobes.web.config;

import java.util.Locale;

public final class Config {

    /**
     * URLs
     */
    private static final String URL_BONI_GARCIA = "https://bonigarcia.dev/selenium-webdriver-java";
    public static final String URL_BONI_GARCIA_LOGIN_FORM = URL_BONI_GARCIA + "/login-form.html";
    public static final String URL_BONI_GARCIA_DROPDOWN_MENU = URL_BONI_GARCIA + "/dropdown-menu.html";
    public static final String URL_BONI_GARCIA_RANDOM_CALCULATOR = URL_BONI_GARCIA + "/random-calculator.html";
    public static final String URL_BONI_GARCIA_INFINITE_SCROLL = URL_BONI_GARCIA + "/infinite-scroll.html";

    public static final String URL_KATALON_DEMO_CURA = "https://katalon-demo-cura.herokuapp.com/";

    /**
     * Locales
     */
    public static final Locale SPANISH_LOCALE = Locale.forLanguageTag("es");

    /**
     * TIMEOUTS
     */
    public static final Integer DEFAULT_TIMEOUT = 10;

    private Config() {

    }
}
