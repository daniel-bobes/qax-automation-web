package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoaderPage extends BaseDemoQAPage {

    private final By runButton = By.xpath("//button[@id='loader']");
    private final By loader = By.xpath("//h1[text()='Please wait...']");
    private final By modal = By.xpath("//div[@id='myModal']");

    public LoaderPage(WebDriver driver) {
        super(driver);
    }

    public void pushOnRun() {
        clickOn(runButton);
    }

    public boolean isLoaderVisible() {
        return isDisplayed(loader);
    }

    public boolean waitForLoaderToClose() {
        return waitToVanish(loader);
    }

    public boolean isModalVisible() {
        return isDisplayed(modal);
    }
}
