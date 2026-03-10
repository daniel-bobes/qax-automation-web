package com.danielbobes.demoautomationtesting.pages;

import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage {

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isWelcomePage() {
        return getTitle().equalsIgnoreCase("Welcome");
    }
}
