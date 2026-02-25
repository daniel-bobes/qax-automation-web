package com.danielbobes.web.tests.katalondemocura;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class NavigationTest extends BaseTest {

    @Test(testName = "Navigation Test")
    public void navigationTest() {
        driver.get(Config.URL_KATALON_DEMO_CURA);

        goToMakeAppointMent();
        login();
        goToHome();
        goToHistory();
        goToProfile();
        logout();
    }

    private void goToMakeAppointMent() {
        wait.until(elementToBeClickable(By.id("btn-make-appointment"))).click();
        wait.until(visibilityOfElementLocated(By.xpath("//h2[text()='Login']")));
    }

    private void login() {
        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        WebElement passwordInput = driver.findElement(By.id("txt-password"));

        usernameInput.clear();
        usernameInput.sendKeys("John Doe");

        passwordInput.clear();
        passwordInput.sendKeys("ThisIsNotAPassword");

        driver.findElement(By.id("btn-login")).click();
        wait.until(visibilityOfElementLocated(By.tagName("h2")));
    }

    private void openSideMenu() {
        driver.findElement(By.id("menu-toggle")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(".sidebar-brand")));
    }

    private void goToHome() {
        openSideMenu();
        driver.findElement(By.linkText("Home")).click();
        WebElement header = wait.until(visibilityOfElementLocated(By.tagName("h2")));
        System.out.println("Page: " + header.getText());
    }

    private void goToHistory() {
        openSideMenu();
        driver.findElement(By.linkText("History")).click();
        WebElement header = wait.until(visibilityOfElementLocated(By.tagName("h2")));
        System.out.println("Page: " + header.getText());
    }

    private void goToProfile() {
        openSideMenu();
        driver.findElement(By.linkText("Profile")).click();
        WebElement header = wait.until(visibilityOfElementLocated(By.tagName("h2")));
        System.out.println("Page: " + header.getText());
    }

    private void logout() {
        openSideMenu();
        driver.findElement(By.linkText("Logout")).click();
        WebElement header = wait.until(visibilityOfElementLocated(By.tagName("h1")));
        System.out.println("Page: " + header.getText());
    }
}
