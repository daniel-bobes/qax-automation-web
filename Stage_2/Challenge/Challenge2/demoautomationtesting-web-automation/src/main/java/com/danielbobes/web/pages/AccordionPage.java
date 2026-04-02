package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccordionPage extends BaseDemoQAPage {

    private final String commonLinkLocator = "//a[contains(normalize-space(), '%s')]";

    private final By readabilityLink = By.xpath(String.format(commonLinkLocator, "Readability"));
    private final By singleLineCodingLink = By.xpath(String.format(commonLinkLocator, "Single Line Coding"));
    private final By methodChainingLink = By.xpath(String.format(commonLinkLocator, "Methhod Chaining"));
    private final By crossBrowserTestingLink = By.xpath(String.format(commonLinkLocator, "Cross Browser Testing"));

    private final By collapse1 = By.xpath("//div[@id='collapse1']");
    private final By collapse2 = By.xpath("//div[@id='collapse2']");
    private final By collapse3 = By.xpath("//div[@id='collapse3']");
    private final By collapse4 = By.xpath("//div[@id='collapse4']");

    public AccordionPage(WebDriver driver) {
        super(driver);
    }

    private void pushOnPanel(By linkLocator, By panel) {
        clickOn(linkLocator);
        if(hasClass(linkLocator, "collapsed")) {
            waitToVanish(panel);
        } else {
            isDisplayed(panel);
        }
    }

    public void pushOnReadability() {
        pushOnPanel(readabilityLink, collapse1);
    }

    public void pushOnSingleLineCoding() {
        pushOnPanel(singleLineCodingLink, collapse2);
    }

    public void pushOnMethodChaining() {
        pushOnPanel(methodChainingLink, collapse3);
    }

    public void pushOnCrossBowserTesting() {
        pushOnPanel(crossBrowserTestingLink, collapse4);
    }

    public boolean isFirstCollapseDisplayed() {
        return isDisplayed(collapse1);
    }

    public boolean isSecondCollapseDisplayed() {
        return isDisplayed(collapse2);
    }

    public boolean isThirdCollapseDisplayed() {
        return isDisplayed(collapse3);
    }

    public boolean isFourthCollapseDisplayed() {
        return isDisplayed(collapse4);
    }
}
