package com.danielbobes.web.pages.bonigarcia;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.xpath("//label[contains(text(), 'Login')]/input");
    private final By passwordInput = By.xpath("//label[contains(text(), 'Password')]/input");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By alertMessage = By.xpath("//div[contains(@class, 'alert')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void typeUsername(String username) {
        typeText(usernameInput, username);
    }

    private void typePassword(String password) {
        typeText(passwordInput, password);
    }

    public void login(String username, String password) {
        typeUsername(username);
        typePassword(password);
        pushOn(loginButton);
    }

    public String getAlertMessageText() {
        return getText(alertMessage);
    }

}
