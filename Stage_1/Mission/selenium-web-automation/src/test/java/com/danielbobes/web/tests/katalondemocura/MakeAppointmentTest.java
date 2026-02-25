package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import com.danielbobes.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MakeAppointmentTest extends BaseTest {

    @Test(testName = "Make Appointment Test")
    public void loginTest() {
        String expectedMessage = "Appointment Confirmation";

        driver.get(Config.URL_KATALON_DEMO_CURA);

        wait.until(elementToBeClickable(By.id("btn-make-appointment"))).click();

        wait.until(visibilityOfElementLocated(By.xpath("//h2[text()='Login']")));

        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        WebElement passwordInput = driver.findElement(By.id("txt-password"));

        usernameInput.clear();
        usernameInput.sendKeys("John Doe");

        passwordInput.clear();
        passwordInput.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();

        wait.until(visibilityOfElementLocated(By.tagName("h2")));

        WebElement facility = driver.findElement(By.id("combo_facility"));
        Select facilitySelect = new Select(facility);
        facilitySelect.selectByVisibleText("Seoul CURA Healthcare Center");

        WebElement applyForHospitalReadmission = driver.findElement(By.id("chk_hospotal_readmission"));
        if (!applyForHospitalReadmission.isSelected()) {
            applyForHospitalReadmission.click();
        }

        WebElement medicareProgram = driver.findElement(By.id("radio_program_medicare"));
        if (!medicareProgram.isSelected()) {
            medicareProgram.click();
        }

        WebElement visitDateInput = driver.findElement(By.id("txt_visit_date"));
        visitDateInput.clear();
        visitDateInput.sendKeys(Utils.getTomorrowsDate());

        WebElement commentInput = driver.findElement(By.id("txt_comment"));
        commentInput.clear();
        commentInput.sendKeys("Cita automatizada con QA Xpert");

        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
        bookAppointmentButton.click();

        WebElement headerMakeAppointment = wait.until(visibilityOfElementLocated(By.tagName("h2")));
        String headerText = headerMakeAppointment.getText();
        AssertJUnit.assertEquals(expectedMessage, headerText);
    }
}
