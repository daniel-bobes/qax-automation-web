package com.danielbobes.web.tests;

import org.openqa.selenium.Alert;
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

public class HandleAlertsTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html";
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Launch alert")
    public void launchAlertTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-alert"));
        launchModalButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Texto de la alerta: " + alertText);

        alert.accept();
    }

    @Test(testName = "Advanced Actions - Launch confirm and press confirm")
    public void launchConfirmAlertAndPressConfirmTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-confirm"));
        launchModalButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Texto de la alerta: " + alertText);

        alert.accept();

        WebElement confirmText = driver.findElement(By.id("confirm-text"));
        System.out.println("Texto de confirmación: " + confirmText.getText());
    }

    @Test(testName = "Advanced Actions - Launch confirm and press dismiss")
    public void launchConfirmAlertAndPressDismissTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-confirm"));
        launchModalButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Texto de la alerta: " + alertText);

        alert.dismiss();

        WebElement confirmText = driver.findElement(By.id("confirm-text"));
        System.out.println("Texto de confirmación: " + confirmText.getText());
    }

    @Test(testName = "Advanced Actions - Launch prompt, send text and press confirm")
    public void launchPromptAlertSendTextAndPressConfirmTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-prompt"));
        launchModalButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Texto de la alerta: " + alertText);

        alert.sendKeys("Web Automation");
        alert.accept();

        WebElement promptText = driver.findElement(By.id("prompt-text"));
        System.out.println("Texto introducido: " + promptText.getText());
    }

    @Test(testName = "Advanced Actions - Launch prompt, send text and press dismiss")
    public void launchPromptAlertSendTextAndPressDismissTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-prompt"));
        launchModalButton.click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Texto de la alerta: " + alertText);

        alert.sendKeys("Web Automation");
        alert.dismiss();

        WebElement promptText = driver.findElement(By.id("prompt-text"));
        System.out.println("Texto introducido: " + promptText.getText());
    }

    @Test(testName = "Advanced Actions - Launch modal and press close")
    public void launchModalAndPressCloseTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-modal"));
        launchModalButton.click();

        WebElement modalBody = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        System.out.println("Texto del modal: " + modalBody.getText());

        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();

        WebElement modalText = driver.findElement(By.id("modal-text"));
        System.out.println("Texto al cerrarse el modal: " + modalText.getText());
    }

    @Test(testName = "Advanced Actions - Launch modal and save changes")
    public void launchModalAndPressSaveChangesTest() {
        WebElement launchModalButton = driver.findElement(By.id("my-modal"));
        launchModalButton.click();

        WebElement modalBody = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("modal-body")));
        System.out.println("Texto del modal: " + modalBody.getText());

        WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(), 'Save')]"));
        closeButton.click();

        WebElement modalText = driver.findElement(By.id("modal-text"));
        System.out.println("Texto al cerrarse el modal: " + modalText.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
