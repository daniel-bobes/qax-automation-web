package com.danielbobes.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class HandleIframesTest {

    private static final String URL = "https://demo.automationtesting.in/Frames.html";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Iframe")
    public void singleFrameTest() {
        consentCookies();
        driver.switchTo().frame("singleframe");

        WebElement paragraph = driver.findElement(By.tagName("h5"));
        System.out.println("Texto dentro del iframe: " + paragraph.getText());

        WebElement input = driver.findElement(By.tagName("input"));
        input.clear();
        input.sendKeys("Probando iframes");
        System.out.println("Texto dentro del input dentro del iframe: " + input.getAttribute("value"));

        driver.switchTo().defaultContent();
    }

    @Test(testName = "Advanced Actions - Iframe with in an iframe")
    public void iFrameInsideIFrameTest() {
        consentCookies();

        driver.findElement(By.linkText("Iframe with in an Iframe")).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#Multiple iframe")));

        WebElement outerFrameText = driver.findElement(By.tagName("h5"));
        System.out.println("Texto dentro del frame exterior: " + outerFrameText.getText());

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".iframe-container iframe")));

        WebElement innerFrameText = driver.findElement(By.tagName("h5"));
        System.out.println("Texto dentro del frame interior: " + innerFrameText.getText());

        WebElement input = driver.findElement(By.tagName("input"));
        input.clear();
        input.sendKeys("Probando iframes");
        System.out.println("Texto del input del frame interior: " + input.getAttribute("value"));

        driver.switchTo().parentFrame();
        System.out.println("Texto dentro del frame exterior: " + outerFrameText.getText());

        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }

    private void consentCookies() {
        WebElement consentCookies = wait.until(
                visibilityOfElementLocated(By.xpath("//button//descendant::p[text()='Consent']")));
        consentCookies.click();
    }
}
