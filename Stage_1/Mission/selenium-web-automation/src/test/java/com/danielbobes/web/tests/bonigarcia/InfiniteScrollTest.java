package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class InfiniteScrollTest extends BaseTest {

    @Test(testName = "Infinite Scroll Test")
    public void infiniteScrollTest() {
        driver.get(Config.URL_BONI_GARCIA_INFINITE_SCROLL);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        By paragraphLocator = By.cssSelector("p.lead");

        List<WebElement> paragraphs = driver.findElements(paragraphLocator);
        System.out.println("Párrafos iniciales: " + paragraphs.size());

        while (paragraphs.size() < 20) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            new Actions(driver).pause(Duration.ofSeconds(1)).perform();
            paragraphs = driver.findElements(paragraphLocator);
            System.out.println("Elementos cargados hasta ahora: " + paragraphs.size());
        }

        System.out.println("Párrafos cargados: ");
        for (WebElement paragraph : paragraphs) {
            System.out.println(paragraph.getText());
        }
    }
}
