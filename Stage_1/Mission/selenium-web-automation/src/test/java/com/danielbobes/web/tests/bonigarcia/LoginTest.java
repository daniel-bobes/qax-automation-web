package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.bonigarcia.LoginPage;
import com.danielbobes.web.tests.BaseTest;
import com.danielbobes.web.utils.DataFactory;
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

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        String alertMessage = loginPage.getAlertMessageText();
        System.out.println("Resultado del login: " + alertMessage);
        assertEquals(expectedMessage, alertMessage);
    }
}
