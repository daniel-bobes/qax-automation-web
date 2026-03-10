package com.danielbobes.demoautomationtesting.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class DriverManager {

    private static WebDriver driver;

    public static void initializeDriver() {
        driver = new ChromeDriver();
    }

    public static WebDriver getDriver() {
        if (Objects.isNull(driver)) {
            initializeDriver();
        }
        return driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        if (!Objects.isNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}
