package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import com.danielbobes.web.utils.DataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;

public class LoginTest extends BaseTest {

    @DataProvider(name = "credentials")
    private String[][] getCredentials() {
        return new String[][] {
                {DataFactory.getUsername(), DataFactory.getPassword(), "Invalid credentials"},
                {"user", "user", "Login successful"}
        };
    }

    @Test(testName = "Login Automático", dataProvider = "credentials",
            description = "Automatizar login con usuario y contraseña de prueba")
    public void wrongLoginTest(String username, String password, String expectedMessage) {
        driver.get(Config.URL_BONI_GARCIA_LOGIN_FORM);

        WebElement loginInput = driver.findElement(By.xpath("//label[contains(text(), 'Login')]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("//label[contains(text(), 'Password')]/input"));

        loginInput.clear();
        loginInput.sendKeys(username);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert')]"));
        String alertMessage = alert.getText();
        System.out.println("Resultado del login: " + alertMessage);
        assertEquals(expectedMessage, alertMessage);
    }
}
