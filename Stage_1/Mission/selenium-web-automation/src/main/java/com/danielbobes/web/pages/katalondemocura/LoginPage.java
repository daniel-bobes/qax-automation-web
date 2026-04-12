package com.danielbobes.web.pages.katalondemocura;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By header = By.tagName("h2");

    private final By usernameInput = By.id("txt-username");
    private final By passwordInput = By.id("txt-password");
    private final By loginButton = By.id("btn-login");
    private final By errorMessage = By.cssSelector("p.text-danger");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        typeText(usernameInput, username);
    }

    public void setPassword(String password) {
        typeText(passwordInput, password);
    }

    public void clickOnLogin() {
        pushOn(loginButton);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLogin();
        waitForVisibilityOfElement(header);
    }

    public String getMessageText() {
        return getText(errorMessage);
    }

}
