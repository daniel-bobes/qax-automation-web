package com.danielbobes.web.challenges.parabank.tests;

import com.danielbobes.web.challenges.parabank.config.Config;
import com.danielbobes.web.challenges.parabank.models.User;
import com.danielbobes.web.challenges.parabank.data.factory.CreateUserDataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Objects;

public class ParabankTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(description = "Challenge 01 - Mi primera automatización")
    public void miPrimeraAutomatizacion() {
        String expectedTitle = "Signing up is easy!";

        // 1. Abrir la aplicación Parabank
        driver.get(Config.PARABANK_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.logo")));

        // 2. Hacer clic en "Register"
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        // 3. Obtener el texto del h1 en la página de registro e imprimirlo por consola
        WebElement registerTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.title")));
        String currentTitle = registerTitle.getText();
        Assert.assertEquals(currentTitle, expectedTitle, "El texto del título no coincide");
        System.out.println("Página de Registro cargada. Encabezado encontrado: " + currentTitle);

        // 4. Ingresar los datos solicitados en el formulario
        User user = CreateUserDataFactory.withAllInformation();
        WebElement fistName = driver.findElement(By.id("customer.firstName"));
        fistName.click();
        fistName.sendKeys(user.getFistName());

        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.clear();
        lastName.sendKeys(user.getLastName());

        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.clear();
        address.sendKeys(user.getAddress());

        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.clear();
        city.sendKeys(user.getCity());

        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.clear();
        state.sendKeys(user.getState());

        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.clear();
        zipCode.sendKeys(user.getZipCode());

        WebElement phone = driver.findElement(By.id("customer.phoneNumber"));
        phone.clear();
        phone.sendKeys(user.getPhone());

        WebElement socialSecurityNumber = driver.findElement(By.id("customer.ssn"));
        socialSecurityNumber.clear();
        socialSecurityNumber.sendKeys(user.getSocialSecurityNumber());

        WebElement usernameInput = driver.findElement(By.id("customer.username"));
        usernameInput.clear();
        usernameInput.sendKeys(user.getUsername());

        WebElement passwordInput = driver.findElement(By.id("customer.password"));
        passwordInput.clear();
        passwordInput.sendKeys(user.getPassword());

        WebElement confirmPasswordInput = driver.findElement(By.id("repeatedPassword"));
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(user.getPassword());

        // 5. Hacer login
        WebElement registerSubmitButton = driver.findElement(By.cssSelector("input.button[value='Register']"));
        registerSubmitButton.click();

        WebElement welcomeTitle = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.title")));
        String currentWelcomeTitle = welcomeTitle.getText();
        Assert.assertEquals(currentWelcomeTitle, "Welcome " + user.getUsername());

        String expectedWelcomeMessage = "Your account was created successfully. You are now logged in.";
        WebElement welcomeMessage = driver.findElement(By.xpath("//h1/following-sibling::p"));
        String currentWelcomeMessage = welcomeMessage.getText();
        Assert.assertEquals(currentWelcomeMessage, expectedWelcomeMessage);
        System.out.println("Página de Login cargada. Encabezado encontrado: " + currentWelcomeMessage);
    }

    @AfterMethod
    public void tearDown(){
        if (!Objects.isNull(driver)){
            // 6. Cerrar el navegador
            driver.quit();
        }
    }
}
