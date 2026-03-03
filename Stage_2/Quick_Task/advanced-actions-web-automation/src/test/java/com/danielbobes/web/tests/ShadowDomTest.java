package com.danielbobes.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class ShadowDomTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Shadow DOM")
    public void iFrameTest() {
        WebElement shadowHost = driver.findElement(By.id("content"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement paragraph = shadowRoot.findElement(By.cssSelector("p"));
        System.out.println("Paragraph text: " + paragraph.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
