package com.danielbobes.demoautomationtesting.pages;

import com.danielbobes.demoautomationtesting.config.DriverManager;
import com.danielbobes.demoautomationtesting.config.GlobalConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConfig.DEFAULT_TIMEOUT));
    }

    private WebElement waitForVisibility(By locator) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected WebElement findElement(By locator) {
        return waitForVisibility(locator);
    }

    protected void clickOnElement(By locator) {
        waitForClickability(locator).click();
    }

    protected void clearField(By locator) {
        findElement(locator).clear();
    }

    protected void sendKeys(By locator, String keysToSend, boolean cleanBeforeSendKeys) {
        WebElement element = findElement(locator);
        if (cleanBeforeSendKeys) {
            element.clear();
        }
        element.sendKeys(keysToSend);
    }

    protected void sendKeys(By locator, String keys) {
        if (!Objects.isNull(keys)) {
            sendKeys(locator, keys, true);
        }
    }

    protected boolean hasClass(By locator, String className) {
        return findElement(locator).getAttribute("class").contains(className);
    }

    protected boolean isEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    protected boolean isSelected(By locator) {
        return findElement(locator).isSelected();
    }

    protected void selectFromDropdownByValue(By locator, String value) {
        if (!Objects.isNull(value)) {
            Select select = new Select(findElement(locator));
            select.selectByValue(value);
        }
    }

    protected void selectFromDropdownByText(By locator, String text) {
        if(!Objects.isNull(text)) {
            Select select = new Select(findElement(locator));
            select.selectByVisibleText(text);
        }
    }

    protected void selectFromDropdownByIndex(By locator, int index) {
        Select select = new Select(findElement(locator));
        select.selectByIndex(index);
    }

    protected void makeAdsDisappear() {
        String adsClass = ".adsbygoogle";
        removeElements(adsClass);
    }

    protected void removeElements(String locator) {
        String script = "document.querySelectorAll(arguments[0]).forEach(e => e.remove())";
        executeScript(script, locator);
    }

    public void executeScript(String script, Object... arguments) {
        ((JavascriptExecutor) driver).executeScript(script, arguments);
    }

    public void waitSeconds(int seconds) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.pause(Duration.ofSeconds(seconds)).perform();
    }

}
