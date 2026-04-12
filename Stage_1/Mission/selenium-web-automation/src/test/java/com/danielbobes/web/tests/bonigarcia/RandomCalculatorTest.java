package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.pages.bonigarcia.RandomCalculatorPage;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class RandomCalculatorTest extends BaseTest {

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

        RandomCalculatorPage randomCalculatorPage = new RandomCalculatorPage(driver);

        randomCalculatorPage.typePercent("0");
        randomCalculatorPage.typeCorrect("0");

        randomCalculatorPage.pushOnButton(String.valueOf(firstOperand));
        randomCalculatorPage.pushOnButton(operator);
        randomCalculatorPage.pushOnButton(String.valueOf(secondOperand));
        randomCalculatorPage.pushOnButton("=");

        WebElement result = driver.findElement(By.className("screen"));
        System.out.println("Resultado de la operación '"
                + firstOperand + " "
                + operator + " "
                + secondOperand + "' = "
                + result.getText());
    }

}
