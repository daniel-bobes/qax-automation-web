package com.danielbobes.web.pages.common;

import com.danielbobes.web.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.DEFAULT_TIMEOUT));
        this.actions = new Actions(driver);
    }

    protected WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> waitForVisibilityOfElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement waitForClickabilityOfElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement find(By locator) {
        return waitForVisibilityOfElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return waitForVisibilityOfElements(locator);
    }

    protected void pushOn(By locator) {
        waitForClickabilityOfElement(locator).click();
    }

    protected void typeText(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    private Select getSelect(By locator) {
        WebElement element = find(locator);
        return new Select(element);
    }

    protected void selectByVisibleText(By locator, String text) {
        Select select = getSelect(locator);
        select.selectByVisibleText(text);
    }

    public boolean isOptionSelected(By locator) {
        return find(locator).isSelected();
    }

    protected void doublePushOn(By locator) {
        WebElement element = find(locator);
        actions.doubleClick(element).perform();
    }

    protected void rightClickPushOn(By locator) {
        WebElement element = find(locator);
        actions.contextClick(element).perform();
    }

    protected void waitForSeconds(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).perform();
    }

    protected void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

}
