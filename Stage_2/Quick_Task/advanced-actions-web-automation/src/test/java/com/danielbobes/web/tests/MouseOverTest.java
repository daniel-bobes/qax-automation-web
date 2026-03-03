package com.danielbobes.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class MouseOverTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
    private static final String COMMON_LOCATOR = "//img[contains(@src, '%s')]";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Mouse Over")
    public void mouseOverTest() {
        WebElement compass = driver.findElement(By.xpath(String.format(COMMON_LOCATOR, "compass")));
        WebElement calendar = driver.findElement(By.xpath(String.format(COMMON_LOCATOR, "calendar")));
        WebElement award = driver.findElement(By.xpath(String.format(COMMON_LOCATOR, "award")));
        WebElement landscape = driver.findElement(By.xpath(String.format(COMMON_LOCATOR, "landscape")));

        Actions actions = new Actions(driver);
        actions.moveToElement(compass)
                .moveToElement(calendar)
                .moveToElement(award)
                .moveToElement(landscape)
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
