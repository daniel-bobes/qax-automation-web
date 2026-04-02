package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsPage extends BaseDemoQAPage {

    private final By tabbedWindowsTab = By.cssSelector("a[href='#Tabbed']");
    private final By separateWindowsTab = By.cssSelector("a[href='#Seperate']");
    private final By multipleWindowsTab = By.cssSelector("a[href='#Multiple']");

    private final By openNewWindowsTabButton = By.cssSelector("#Tabbed button");
    private final By openSeparateWindowsButton = By.cssSelector("#Seperate button");
    private final By openMultipleWindowsButton = By.cssSelector("#Multiple button");

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public void selectNewTabbedWindowsTab() {
        clickOn(tabbedWindowsTab);
    }

    public void selectSeparateWindowsTab() {
        clickOn(separateWindowsTab);
    }

    public void selectMultipleWindowsTab() {
        clickOn(multipleWindowsTab);
    }

    public void openNewTab() {
        clickOn(openNewWindowsTabButton);
    }

    public void openSeparateWindow() {
        clickOn(openSeparateWindowsButton);
    }

    public void openMultipleWindows() {
        clickOn(openMultipleWindowsButton);
    }


}
