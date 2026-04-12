package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.katalondemocura.HomePage;
import com.danielbobes.web.pages.katalondemocura.LoginPage;
import com.danielbobes.web.pages.katalondemocura.MakeAppointmentPage;
import com.danielbobes.web.tests.BaseTest;
import com.danielbobes.web.utils.Utils;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MakeAppointmentTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MakeAppointmentPage makeAppointmentPage;

    @BeforeMethod
    public void setUp() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        makeAppointmentPage = new MakeAppointmentPage(driver);
        driver.get(Config.URL_KATALON_DEMO_CURA);
    }

    @Test(testName = "Make Appointment Test")
    public void loginTest() {
        String username = "John Doe", password = "ThisIsNotAPassword";
        String facility = "Seoul CURA Healthcare Center";
        String comment = "Cita automatizada con QA Xpert";
        String expectedMessage = "Appointment Confirmation";

        homePage.goToMakeAppointment();

        loginPage.login(username, password);

        makeAppointmentPage.selectFacility(facility);
        makeAppointmentPage.applyHospitalReadmission();
        makeAppointmentPage.selectMedicareProgram();
        makeAppointmentPage.typeVisitDate(Utils.getTomorrowsDateAsString());
        makeAppointmentPage.typeComment(comment);

        makeAppointmentPage.pushOnBookAppointment();
        AssertJUnit.assertEquals(expectedMessage, makeAppointmentPage.getHeaderText());
    }
}
