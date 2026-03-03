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

public class ClickTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advance Actions - Left Click")
    public void leftClickTest() {
        WebElement dropdownMenu = driver.findElement(By.id("my-dropdown-1"));

        Actions actions = new Actions(driver);
        actions.click(dropdownMenu)
                .perform();
    }

    @Test(testName = "Advanced Actions - Right Click")
    public void rightClickTest() {
        WebElement dropdownMenu = driver.findElement(By.id("my-dropdown-2"));

        Actions actions = new Actions(driver);
        actions.contextClick(dropdownMenu)
                .perform();
    }

    @Test(testName = "Advanced Actions - Double Click")
    public void doubleClickTest() {
        WebElement dropdownMenu = driver.findElement(By.id("my-dropdown-3"));

        Actions actions = new Actions(driver);
        actions.doubleClick(dropdownMenu)
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
