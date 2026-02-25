package com.danielbobes.web.tests;

import com.danielbobes.web.config.Config;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class BaseTest {

    private static ChromeOptions options;
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public static void setUpOptions() {
        options = new ChromeOptions();

        Map<String, Object> preferences = new HashMap<>();
        preferences.put("profile.password_manager_leak_detection", false);
        preferences.put("profile.credentials_enable_service", false);
        options.setExperimentalOption("prefs", preferences);

        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT));
        driver.manage().window().setSize(new Dimension(1920,1080));
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
