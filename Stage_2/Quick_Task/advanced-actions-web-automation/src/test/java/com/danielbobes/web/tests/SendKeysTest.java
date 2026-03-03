package com.danielbobes.web.tests;

import com.beust.jcommander.IStringConverterInstanceFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;
import java.util.Random;

public class SendKeysTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";
    private static final String COMMON_LOCATOR = "//div[@class='keys']/span[text()='%s']";
    private static final Integer DELAY_TIME = 2;
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test(testName = "Advanced Actions - Send keys")
    public void sendKeysTest() {
        WebElement delayInput = driver.findElement(By.id("delay"));

        Random random = new Random();
        WebElement firstOperand = driver.findElement(
                By.xpath(String.format(COMMON_LOCATOR, random.nextInt(10))));
        WebElement secondOperand = driver.findElement(
                By.xpath(String.format(COMMON_LOCATOR, random.nextInt(10))));
        WebElement addOperatorButton = driver.findElement(
                By.xpath(String.format(COMMON_LOCATOR, "+")));
        WebElement equalsButton = driver.findElement(
                By.xpath(String.format(COMMON_LOCATOR, "=")));

        Actions actions = new Actions(driver);
        actions.click(delayInput)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(String.valueOf(DELAY_TIME))
                .click(firstOperand)
                .click(addOperatorButton)
                .click(secondOperand)
                .click(equalsButton)
                .pause(Duration.ofSeconds(DELAY_TIME + 1))
                .perform();
    }

    @AfterMethod
    public void tearDown() {
        if (!Objects.isNull(driver)) {
            driver.quit();
        }
    }
}
