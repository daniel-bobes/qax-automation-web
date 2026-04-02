package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgressBarPage extends BaseDemoQAPage {

    private final By downloadButton = By.xpath("//button[@id='cricle-btn']");
    private final By progressBarText = By.xpath("//div[@class='progressbar-text']");

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public void pushOnDownload() {
        clickOn(downloadButton);
    }

    public String getProgressBarText() {
        return getText(progressBarText);
    }

    public boolean waitForProgressBarToComplete() {
        return waitForTextToBe(progressBarText, "100");
    }

}
