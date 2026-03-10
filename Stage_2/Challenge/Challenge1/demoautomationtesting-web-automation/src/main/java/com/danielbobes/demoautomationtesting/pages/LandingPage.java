package com.danielbobes.demoautomationtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

    private By consentCookiesButton = By.cssSelector("button[aria-label='Consent']");

    private By emailInput = By.id("email");
    private By enteringButton = By.id("enterimg");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void typeEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void clickOnEnterButton() {
        clickOnElement(enteringButton);
        consentCookies();
        makeAdsDisappear();
    }

    public boolean isLandingPage() {
        return getTitle().equalsIgnoreCase("Index");
    }

    public boolean isEmailInvalid() {
        return hasClass(emailInput, "ng-invalid");
    }

    public boolean isEnterButtonEnabled() {
        return isEnabled(enteringButton);
    }

    public void consentCookies() {
        clickOnElement(consentCookiesButton);
    }
}
