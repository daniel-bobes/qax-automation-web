package com.danielbobes.web.pages.bonigarcia;

import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RandomCalculatorPage extends BasePage {

    private static final String COMMON_LOCATOR = "//div[@class='keys']/span[text()='%s']";
    private final By percentInput = By.id("percent");
    private final By correctInput = By.id("correct");

    public RandomCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void typePercent(String percent) {
        typeText(percentInput, percent);
    }

    public void typeCorrect(String correct) {
        typeText(correctInput, correct);
    }

    public void pushOnButton(String button) {
        pushOn(By.xpath(String.format(COMMON_LOCATOR, button)));
    }

}
