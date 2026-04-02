package com.danielbobes.web.pages;

import org.openqa.selenium.WebDriver;

public class BaseDemoQAPage extends BasePage {

    public BaseDemoQAPage(WebDriver driver) {
        super(driver);
        consentCookies();
        makeAdsDisappear();
    }

}
