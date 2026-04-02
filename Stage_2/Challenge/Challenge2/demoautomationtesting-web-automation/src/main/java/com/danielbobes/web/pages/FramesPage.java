package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BaseDemoQAPage {

    private final By singleIFrameTab = By.cssSelector("a[href='#Single']");
    private final By nestedIFramesTab = By.cssSelector("a[href='#Multiple']");

    private final By singleFrame = By.id("singleframe");
    private final By outerFrame = By.cssSelector("#Multiple iframe");
    private final By innerFrame = By.cssSelector(".iframe-container iframe");

    private final By inputText = By.tagName("input");
    private final By headerTitle = By.tagName("h5");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void selectSingleIFrameTab() {
        clickOn(singleIFrameTab);
    }

    public void selectNestedIFramesTab() {
        clickOn(nestedIFramesTab);
    }

    public void switchToSingleFrame() {
        switchToFrame(singleFrame);
    }

    public void switchToOuterFrame() {
        switchToFrame(outerFrame);
    }

    public void switchToInnerFrame() {
        switchToFrame(innerFrame);
    }

    public String getHeaderTitle() {
        return getText(headerTitle);
    }

    public void sendInputText(String keysToSend) {
        sendKeys(inputText, keysToSend);
    }

    public String getInputText() {
        return getValue(inputText);
    }

    public void goToDefaultContent() {
        switchToDefaultContent();
    }

    public boolean isOnFramesPage() {
        return isDisplayed(singleIFrameTab);
    }

}
