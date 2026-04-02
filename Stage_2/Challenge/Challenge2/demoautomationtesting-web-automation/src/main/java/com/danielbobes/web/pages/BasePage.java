package com.danielbobes.web.pages;

import com.danielbobes.web.config.GlobalConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SuppressWarnings("unused")
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConfig.DEFAULT_TIMEOUT));
        this.actions = new Actions(driver);
    }

    protected WebElement waitForVisibility(By locator) {
       try {
           return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       } catch (TimeoutException exception) {
           return null;
       }
    }

    protected List<WebElement> waitForVisibilityOfElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement waitForClickability(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected boolean waitToVanish(By locator) {
       try {
           return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
       } catch (TimeoutException exception) {
           System.out.println("Timeout waiting for invisibility of element located by " + locator);
           return false;
       }
    }

    protected boolean waitForTextToBe(By locator, String value) {
        return wait.until(ExpectedConditions.textToBe(locator, value));
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    protected WebElement find(By locator) {
        return waitForVisibility(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return waitForVisibilityOfElements(locator);
    }

    protected void clickOn(By locator) {
        waitForClickability(locator).click();
    }

    protected void clearField(By locator) {
        find(locator).clear();
    }

    protected void sendKeys(By locator, String keysToSend, boolean clear) {
        WebElement element = find(locator);
        if (clear) {
            element.clear();
        }
        if (!Objects.isNull(keysToSend)) {
            element.sendKeys(keysToSend);
        }
    }

    protected void sendKeys(By locator, String keys) {
        sendKeys(locator, keys, true);
    }

    protected String getText(By locator) {
        return find(locator).getText().trim();
    }

    protected String getAttribute(By locator, String attributeName) {
        return find(locator).getAttribute(attributeName);
    }

    protected String getValue(By locator) {
        return find(locator).getAttribute("value");
    }

    protected boolean hasClass(By locator, String className) {
        String classAttribute = find(locator).getAttribute("class");
        return !Objects.isNull(classAttribute) && classAttribute.contains(className);
    }

    protected boolean isEnabled(By locator) {
        return find(locator).isEnabled();
    }

    protected boolean isDisplayed(By locator) {
        Optional<WebElement> element = Optional.ofNullable(find(locator));
        return element.map(WebElement::isDisplayed).orElse(false);
    }

    protected boolean isSelected(By locator) {
        return find(locator).isSelected();
    }

    protected void selectFromDropdownByValue(By locator, String value) {
        if (!Objects.isNull(value)) {
            Select select = new Select(find(locator));
            select.selectByValue(value);
        }
    }

    protected void selectFromDropdownByText(By locator, String text) {
        if(!Objects.isNull(text)) {
            Select select = new Select(find(locator));
            select.selectByVisibleText(text);
        }
    }

    protected void selectFromDropdownByIndex(By locator, int index) {
        Select select = new Select(find(locator));
        select.selectByIndex(index);
    }

    protected Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        waitForAlert().accept();
    }

    protected void dismissAlert() {
        waitForAlert().dismiss();
    }

    protected String getAlertText() {
        return waitForAlert().getText().trim();
    }

    protected void sendTextToAlert(String keysToSend) {
        waitForAlert().sendKeys(keysToSend);
    }

    protected void switchToFrame(By locator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    protected void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchToWindow(String nameOrHandle) {
        driver.switchTo().window(nameOrHandle);
    }

    public void waitSeconds(int seconds) {
        actions.pause(Duration.ofSeconds(seconds)).perform();
    }

    protected void dragAndDrop(By source, By target) {
        WebElement from = find(source);
        WebElement to = find(target);
        actions.dragAndDrop(from, to).perform();
    }

    protected void hoverMenu(By locator) {
        actions.moveToElement(find(locator)).perform();
    }

    protected void clickOnSubMenu(By topMenuLocator, By subMenuLocator) {
        hoverMenu(topMenuLocator);
        clickOn(subMenuLocator);
    }

    protected void executeScript(String script, Object... arguments) {
        ((JavascriptExecutor) driver).executeScript(script, arguments);
    }

    protected void removeElements(String locator) {
        String script = "document.querySelectorAll(arguments[0]).forEach(e => e.remove())";
        executeScript(script, locator);
    }

    protected void makeAdsDisappear() {
        String adsClass = ".adsbygoogle";
        removeElements(adsClass);
    }

    protected void consentCookies() {
        By consentCookiesButton = By.cssSelector("button[aria-label='Consent']");
        try {
            clickOn(consentCookiesButton);
        } catch (TimeoutException exception) {
            System.out.println("No se mostró la pantalla de cookies");
        }
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public void switchToNewWindow(String windowHandle) {
        for(String handle : driver.getWindowHandles()) {
            if(!handle.equals(windowHandle)) {
                switchToWindow(handle);
            }
        }
    }

    public void closeWindow() {
        driver.close();
    }

    protected String getCssValue(By locator, String propertyName) {
        return find(locator).getCssValue(propertyName);
    }

    protected void moveHorizontalSlider(By locator, int horizontalOffset) {
        WebElement element = find(locator);
        actions.moveToElement(element)
                .clickAndHold()
                .moveByOffset(horizontalOffset, 0).
                perform();
    }

}
