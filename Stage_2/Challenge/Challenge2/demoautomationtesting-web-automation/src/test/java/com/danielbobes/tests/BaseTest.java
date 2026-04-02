package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Objects;

public class BaseTest {

    protected WebDriver driver;
    protected String baseURL;

    @BeforeMethod
    public void setUpDriver() {
        driver = getDriver();
        baseURL = getBaseURL();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if(!Objects.isNull(driver)){
            driver.quit();
        }
    }

    private String getBaseURL() {
        return System.getProperty("baseURL", GlobalConfig.URL_DEMO_AUTOMATION_TESTING);
    }

    private WebDriver getDriver() {
        String browserName = System.getProperty("browserName", "chrome").toLowerCase();
        return switch (browserName) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Navegador no soportado: " + browserName);
        };
    }

}
