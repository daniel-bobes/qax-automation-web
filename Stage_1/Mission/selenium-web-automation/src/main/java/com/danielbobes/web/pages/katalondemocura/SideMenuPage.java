package com.danielbobes.web.pages.katalondemocura;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuPage extends BasePage {

    private final By toggleMenuButton = By.id("menu-toggle");
    private final By sidebarBrand = By.cssSelector(".sidebar-brand");

    private final By homeLink = By.linkText("Home");
    private final By historyLink = By.linkText("History");
    private final By profileLink = By.linkText("Profile");
    private final By logoutLink = By.linkText("Logout");

    private final By firstHeader = By.tagName("h1");
    private final By secondHeader = By.tagName("h2");

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    public void openSideMenu() {
        pushOn(toggleMenuButton);
        waitForVisibilityOfElement(sidebarBrand);
    }

    private void navigateToLink(By locator) {
        openSideMenu();
        pushOn(locator);
    }

    public void goToHome() {
        navigateToLink(homeLink);
    }

    public void goToHistory() {
        navigateToLink(historyLink);
    }

    public void goToProfile() {
        navigateToLink(profileLink);
    }

    public void logout() {
        navigateToLink(logoutLink);
    }

    public String getFirstHeaderText() {
        return getText(firstHeader);
    }

    public String getSecondHeaderText() {
        return getText(secondHeader);
    }

}
