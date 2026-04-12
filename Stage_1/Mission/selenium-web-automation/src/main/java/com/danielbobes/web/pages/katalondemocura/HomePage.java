package com.danielbobes.web.pages.katalondemocura;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By makeAppointmentButton = By.id("btn-make-appointment");
    private final By loginHeader = By.xpath("//h2[text()='Login']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToMakeAppointment() {
        pushOn(makeAppointmentButton);
        waitForVisibilityOfElement(loginHeader);
    }

}
