package com.danielbobes.web.pages.katalondemocura;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeAppointmentPage extends BasePage {

    private final By header = By.tagName("h2");

    private final By facilitySelect = By.id("combo_facility");
    private final By hospitalReadmissionOption = By.id("chk_hospotal_readmission");
    private final By medicareProgramOption = By.id("radio_program_medicare");
    private final By visitDateInput = By.id("txt_visit_date");
    private final By commentInput = By.id("txt_comment");
    private final By bookAppointmentButton = By.id("btn-book-appointment");

    public MakeAppointmentPage(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return getText(header);
    }

    public void selectFacility(String facility) {
        selectByVisibleText(facilitySelect, facility);
    }

    public void applyHospitalReadmission() {
        if(isOptionSelected(hospitalReadmissionOption)) {
            pushOn(hospitalReadmissionOption);
        }
    }

    public void selectMedicareProgram() {
        if (isOptionSelected(medicareProgramOption)) {
            pushOn(medicareProgramOption);
        }
    }

    public void typeVisitDate(String visitDate) {
        typeText(visitDateInput, visitDate);
    }

    public void typeComment(String comment) {
        typeText(commentInput, comment);
    }

    public void pushOnBookAppointment() {
        pushOn(bookAppointmentButton);
    }

}
