package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.katalondemocura.HomePage;
import com.danielbobes.web.pages.katalondemocura.LoginPage;
import com.danielbobes.web.pages.katalondemocura.MakeAppointmentPage;
import com.danielbobes.web.tests.BaseTest;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginDemoCuraTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(Config.URL_KATALON_DEMO_CURA);
    }

    @Test(testName = "Login Failed Test")
    public void loginFailedTest() {
        String username = "QAX", password = "ThisIsNotAPassword";
        String expectedMessage = "Login failed! Please ensure the username and password are valid.";

        homePage.goToMakeAppointment();
        loginPage.login(username,password);

        AssertJUnit.assertEquals(expectedMessage, loginPage.getMessageText());
    }

    @Test(testName = "Login Test")
    public void loginTest() {
        String username = "John Doe", password = "ThisIsNotAPassword";
        String expectedMessage = "Make Appointment";

        homePage.goToMakeAppointment();
        loginPage.login(username,password);

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        AssertJUnit.assertEquals(expectedMessage, makeAppointmentPage.getHeaderText());
        System.out.println("Inicio de sesión exitoso");
    }

}
