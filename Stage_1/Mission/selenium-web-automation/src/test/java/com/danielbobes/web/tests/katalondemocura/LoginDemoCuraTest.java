package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class LoginDemoCuraTest extends BaseTest {

    @Test(testName = "Login Failed Test")
    public void loginFailedTest() {
        String expectedMessage = "Login failed! Please ensure the username and password are valid.";
        driver.get(Config.URL_KATALON_DEMO_CURA);

        goToMakeAppointMent();
        login("QAX", "ThisIsNotAPassword");

        WebElement message = wait.until(visibilityOfElementLocated(By.cssSelector("p.text-danger")));
        AssertJUnit.assertEquals(expectedMessage, message.getText());
    }

    @Test(testName = "Login Test")
    public void loginTest() {
        String expectedMessage = "Make Appointment";
        driver.get(Config.URL_KATALON_DEMO_CURA);

        goToMakeAppointMent();
        login("John Doe", "ThisIsNotAPassword");

        WebElement headerMakeAppointment = wait.until(visibilityOfElementLocated(By.tagName("h2")));
        String headerText = headerMakeAppointment.getText();
        AssertJUnit.assertEquals(expectedMessage, headerText);
        System.out.println("Inicio de sesión exitoso");
    }

    private void goToMakeAppointMent() {
        wait.until(elementToBeClickable(By.id("btn-make-appointment"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h2[text()='Login']")));
    }

    private void login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        WebElement passwordInput = driver.findElement(By.id("txt-password"));

        usernameInput.clear();
        usernameInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(By.id("btn-login")).click();
    }
}
