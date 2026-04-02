package com.danielbobes.web.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class AlertsPage extends BaseDemoQAPage {
    private static final String linkByText = "//a[normalize-space(text())='%s']";
    private static final String launchAlertButton = "#%s button";

    private final By simpleAlertLink = By.xpath(String.format(linkByText, "Alert with OK"));
    private final By confirmAlertLink = By.xpath(String.format(linkByText, "Alert with OK & Cancel"));
    private final By promptAlertLink = By.xpath(String.format(linkByText, "Alert with Textbox"));

    private final By simpleAlertButton = By.cssSelector(String.format(launchAlertButton, "OKTab"));
    private final By confirmAlertButton = By.cssSelector(String.format(launchAlertButton, "CancelTab"));
    private final By promptAlertButton = By.cssSelector(String.format(launchAlertButton, "Textbox"));

    private final By confirmAlertResultText = By.id("demo");
    private final By promptAlertResultText = By.id("demo1");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    // Select type of alert
    public void openSimpleAlert() {
        selectAlertType(simpleAlertLink);
        clickOn(simpleAlertButton);
    }

    public void openConfirmAlert() {
        selectAlertType(confirmAlertLink);
        clickOn(confirmAlertButton);
    }

    public void openPromptAlert() {
        selectAlertType(promptAlertLink);
        clickOn(promptAlertButton);
    }

    private void selectAlertType(By locator) {
        //consentCookies();
        //makeAdsDisappear();
        clickOn(locator);
    }

    public void handleAlert(boolean accept, String textToSend) {
        Alert alert = waitForAlert();
        if (!Objects.isNull(textToSend)) {
            alert.sendKeys(textToSend);
        }
        if (accept) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    public void handleAlert(boolean accept) {
        handleAlert(accept, null);
    }

    public String getConfirmAlertResultText() {
        return getText(confirmAlertResultText).trim();
    }

    public String getPromptAlertResultText() {
        return getText(promptAlertResultText).trim();
    }

    public boolean isConfirmResultTextInvisible() {
        return waitToVanish(confirmAlertResultText);
    }

    public boolean isPromptResultTextInvisible() {
        return waitToVanish(promptAlertResultText);
    }

}
