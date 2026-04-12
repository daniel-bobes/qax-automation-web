package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.katalondemocura.HomePage;
import com.danielbobes.web.pages.katalondemocura.LoginPage;
import com.danielbobes.web.pages.katalondemocura.MakeAppointmentPage;
import com.danielbobes.web.pages.katalondemocura.SideMenuPage;
import com.danielbobes.web.tests.BaseTest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    @Test(testName = "Navigation Test")
    public void navigationTest() {
        String username = "John Doe", password = "ThisIsNotAPassword";
        String expectedMessage = "Make Appointment";

        driver.get(Config.URL_KATALON_DEMO_CURA);

        HomePage homePage = new HomePage(driver);
        homePage.goToMakeAppointment();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        AssertJUnit.assertEquals(expectedMessage, makeAppointmentPage.getHeaderText());

        SideMenuPage sideMenuPage = new SideMenuPage(driver);

        sideMenuPage.goToHome();
        System.out.println("Page: " + sideMenuPage.getSecondHeaderText());

        sideMenuPage.goToHistory();
        System.out.println("Page: " + sideMenuPage.getSecondHeaderText());

        sideMenuPage.goToProfile();
        System.out.println("Page: " + sideMenuPage.getSecondHeaderText());

        sideMenuPage.logout();
        System.out.println("Page: " + sideMenuPage.getFirstHeaderText());
    }

}
