package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.Random;

public class RandomCalculatorTest extends BaseTest {

    private static final String COMMON_LOCATOR = "//div[@class='keys']/span[text()='%s']";

    @DataProvider(name = "calculator")
    private Object[][] getTestData() {
        Random random = new Random();

        return new Object[][] {
                {random.nextInt(10), random.nextInt(10), "+"},
                {random.nextInt(10), random.nextInt(10), "-"},
                {random.nextInt(10), random.nextInt(10), "x"},
                {random.nextInt(10), random.nextInt(10), "÷"}
        };
    }

    @Test(testName = "Random Calculator Test", dataProvider = "calculator")
    public void test(int firstOperand, int secondOperand, String operator) {
        driver.get(Config.URL_BONI_GARCIA_RANDOM_CALCULATOR);

        WebElement percentInput = driver.findElement(By.id("percent"));
        percentInput.clear();
        percentInput.sendKeys("0");

        WebElement correctInput = driver.findElement(By.id("correct"));
        correctInput.clear();
        correctInput.sendKeys("0");

        clickCalculatorButton(String.valueOf(firstOperand));
        clickCalculatorButton(operator);
        clickCalculatorButton(String.valueOf(secondOperand));
        clickCalculatorButton("=");

        WebElement result = driver.findElement(By.className("screen"));
        System.out.println("Resultado de la operación '"
                + firstOperand + " "
                + operator + " "
                + secondOperand + "' = "
                + result.getText());
    }

    private void clickCalculatorButton(String button) {
        wait.until(elementToBeClickable(By.xpath(String.format(COMMON_LOCATOR, button)))).click();
    }

}
