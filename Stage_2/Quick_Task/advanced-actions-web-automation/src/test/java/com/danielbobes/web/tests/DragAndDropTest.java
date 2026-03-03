package com.danielbobes.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class DragAndDropTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html";
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Drag and Drop")
    public void dragAndDropTest() {
        WebElement origin = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(origin, target)
                .perform();
    }

    @Test(testName = "Advanced Actions - Drag and Drop (alternative)")
    public void dragAndDropAlternativeTest() {
        WebElement origin = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(origin)
                .moveToElement(target)
                .release()
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
