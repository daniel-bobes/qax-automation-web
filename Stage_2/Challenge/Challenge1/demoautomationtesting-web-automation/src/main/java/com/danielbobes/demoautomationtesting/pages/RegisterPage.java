package com.danielbobes.demoautomationtesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class RegisterPage extends BasePage {

    // Full name
    private By firstNameInput = By.cssSelector("input[placeholder='First Name']");
    private By lastNameInput = By.cssSelector("input[placeholder='Last Name']");
    // Address
    private By addressInput = By.cssSelector("textarea[ng-model='Adress']");
    // Email address
    private By emailInput = By.cssSelector("input[ng-model='EmailAdress']");
    // Phone
    private By phoneInput = By.cssSelector("input[ng-model='Phone']");
    // Gender
    private By genderMaleOption = By.xpath("//input[@type='radio' and @value='Male']");
    private By genderFemaleOption = By.xpath("//input[@type='radio' and @value='FeMale']");
    // Hobbies
    private By cricketCheckbox = By.id("checkbox1");
    private By moviesCheckbox = By.id("checkbox2");
    private By hockeyCheckbox = By.id("checkbox3");
    // Skills
    private By skillsSelect = By.id("Skills");
    // Country
    private By countrySelect = By.id("country");
    // Date of birth
    private By yearSelect = By.id("yearbox");
    private By monthSelect = By.cssSelector("select[placeholder='Month']");
    private By daySelect = By.id("daybox");
    // Password
    private By passwordInput = By.id("firstpassword");
    private By confirmPasswordInput = By.id("secondpassword");
    // Photo
    private By file_upload = By.id("imagesrc");
    // For buttons
    private By submitButton = By.id("submitbtn");
    private By refreshButton = By.id("Button1");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegisterPage() {
        return getTitle().equalsIgnoreCase("Register");
    }

    public void fillFirstName(String firstName) {
        sendKeys(firstNameInput, firstName);
    }

    public void fillLastName(String lastName) {
        sendKeys(lastNameInput, lastName);
    }

    public void fillAddress(String address) {
        sendKeys(addressInput, address);
    }

    public void fillEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void fillPhone(String phone) {
        sendKeys(phoneInput, phone);
    }

    public void fillPersonalInfo(String firstName, String lastName, String address, String email, String phone) {
        fillFirstName(firstName);
        fillLastName(lastName);
        fillAddress(address);
        fillEmail(email);
        fillPhone(phone);
    }

    public void selectGender(String gender) {
        if (!Objects.isNull(gender)) {
            if ("Male".equalsIgnoreCase(gender)) clickOnElement(genderMaleOption);
            if ("FeMale".equalsIgnoreCase(gender)) clickOnElement(genderFemaleOption);
        }
    }

    public void selectHobby(String hobby) {
        if (!Objects.isNull(hobby)) {
            if ("Cricket".equalsIgnoreCase(hobby)) clickOnElement(cricketCheckbox);
            if ("Movies".equalsIgnoreCase(hobby)) clickOnElement(moviesCheckbox);
            if ("Hockey".equalsIgnoreCase(hobby)) clickOnElement(hockeyCheckbox);
        }
    }

    public void selectSkill(String skill) {
        selectFromDropdownByText(skillsSelect, skill);
    }

    public void selectCountry(String country) {
        selectFromDropdownByText(countrySelect, country);
    }

    public void fillAdditionalInfo(String gender, String hobby, String skill, String country) {
        selectGender(gender);
        selectHobby(hobby);
        selectSkill(skill);
        selectCountry(country);
    }

    public void selectYear(String year) {
        selectFromDropdownByText(yearSelect, year);
    }

    public void selectMonth(String month) {
        selectFromDropdownByText(monthSelect, month);
    }

    public void selectDay(String day) {
        selectFromDropdownByText(daySelect, day);
    }

    public void selectBirthDate(String year, String month, String day) {
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }

    public void fillPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        sendKeys(confirmPasswordInput, confirmPassword);
    }

    public void fillSecurityInfo(String password, String confirmPassword) {
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
    }

    public boolean isSubmitButtonEnabled() {
        return isEnabled(submitButton);
    }

    private By getLocatorForField(String fieldName) {
        return switch (fieldName.toLowerCase()) {
            case "nombre" -> firstNameInput;
            case "apellidos" -> lastNameInput;
            case "dirección" -> addressInput;
            case "email" -> emailInput;
            case "teléfono" -> phoneInput;
            case "genero" -> genderMaleOption;
            case "skills" -> skillsSelect;
            case "país" -> countrySelect;
            case "año" -> yearSelect;
            case "mes" -> monthSelect;
            case "día" -> daySelect;
            case "contraseña" -> passwordInput;
            case "confirmación de contraseña" -> confirmPasswordInput;
            default -> throw new IllegalArgumentException("Campo no definido en el mapeo: " + fieldName);
        };
    }

    public boolean isFieldInvalid(String fieldName) {
        By locator = getLocatorForField(fieldName);
        return hasClass(locator, "ng-invalid");
    }

    public void clickOnSubmit() {
        clickOnElement(submitButton);
    }

    public void clickOnRefresh() {
        clickOnElement(refreshButton);
    }

}
