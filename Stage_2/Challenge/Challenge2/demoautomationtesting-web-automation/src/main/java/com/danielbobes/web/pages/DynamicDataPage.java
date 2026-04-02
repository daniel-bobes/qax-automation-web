package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicDataPage extends BaseDemoQAPage {

    private final String commonImageLocator = "//div[@id='loading']/img[contains(@src, '%s')]";

    private final By getDynamicDataButton = By.xpath("//button[text()='Get Dynamic Data']");
    private final By spinnerImage = By.xpath(String.format(commonImageLocator, "at_spinner"));
    private final By randomUserImage = By.xpath(String.format(commonImageLocator, "randomuser"));

    public DynamicDataPage(WebDriver driver) {
        super(driver);
    }

    public void pushOnGetDynamicData() {
        clickOn(getDynamicDataButton);
        waitToVanish(spinnerImage);
        waitForVisibility(randomUserImage);
    }

    public String getLoadingText() {
        return getText(By.xpath("//div[@id='loading']"));
    }

}
