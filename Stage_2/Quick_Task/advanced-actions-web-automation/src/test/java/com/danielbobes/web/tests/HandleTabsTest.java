package com.danielbobes.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HandleTabsTest {

    private static final String URL = "https://demo.automationtesting.in/Windows.html";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Open New Tab")
    public void openNewTabWindowsTest() {
        String mainWindow = driver.getWindowHandle();
        consentCookies();

        WebElement link = driver.findElement(By.linkText("Open New Tabbed Windows"));
        link.click();

        WebElement clickButton = wait.until(visibilityOfElementLocated(By.cssSelector("#Tabbed button")));
        clickButton.click();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Navegamos a la página " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
    }

    @Test(testName = "Advanced Actions - Open New Separate Windows")
    public void openNewSeparateWindowsTest() {
        String mainWindow = driver.getWindowHandle();
        consentCookies();

        WebElement link = driver.findElement(By.partialLinkText("Open New Seperate Windows"));
        link.click();

        WebElement clickButton = driver.findElement(By.cssSelector("#Seperate > button"));
        clickButton.click();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Navegamos a la página " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
    }

    @Test(testName = "Advanced Actions - Open New Multiple Windows")
    public void openSeparateMultipleWindowsTest() {
        String mainWindow = driver.getWindowHandle();
        consentCookies();

        WebElement link = driver.findElement(By.partialLinkText("Open Seperate Multiple Windows"));
        link.click();

        WebElement clickButton = wait.until(elementToBeClickable(By.cssSelector("#Multiple > button")));
        clickButton.click();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equalsIgnoreCase(mainWindow)) {
                driver.switchTo().window(window);
                System.out.println("Navegamos a la página " + driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
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
