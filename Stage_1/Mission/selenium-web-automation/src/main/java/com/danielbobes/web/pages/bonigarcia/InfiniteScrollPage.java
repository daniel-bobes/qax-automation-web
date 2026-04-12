package com.danielbobes.web.pages.bonigarcia;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InfiniteScrollPage extends BasePage {

    private final By paragraphLocator = By.cssSelector("p.lead");

    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
    }

    public void doInfiniteScroll(int times) {
        List<WebElement> paragraphs = findElements(paragraphLocator);
        while (paragraphs.size() < times) {
            executeScript("window.scrollTo(0, document.body.scrollHeight)");
            waitForSeconds(1);
            paragraphs = findElements(paragraphLocator);
            System.out.println("Elementos cargados hasta ahora: " + paragraphs.size());
        }
    }

    public List<String> getParagraphs() {
        return findElements(paragraphLocator).stream()
                .map(WebElement::getText)
                .toList();
    }

}
