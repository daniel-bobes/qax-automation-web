package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Month;
import java.time.YearMonth;

public class DatePickerPage extends BaseDemoQAPage {

    private final String dayXPathLocator = "//td/a[text()='%s']";

    private final By disabledDatepickerInput = By.xpath("//input[@id='datepicker1']");
    private final By actualMonthAndYear = By.xpath("//div[@class='ui-datepicker-title']");
    private final By prevLink = By.xpath("//a[@title='Prev']");
    private final By nextLink = By.xpath("//a[@title='Next']");

    private final By enabledDatepickerInput = By.xpath("//input[@id='datepicker2']");
    private final By monthDropdown = By.xpath("//select[@title='Change the month']");
    private final By yearDropdown = By.xpath("//select[@title='Change the year']");

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    public void fillEnabledDatePicker(String date) {
        sendKeys(enabledDatepickerInput, date + Keys.TAB);
    }

    public void selectPrevMonth() {
        clickOn(prevLink);
    }

    public void selectNextMonth() {
        clickOn(nextLink);
    }

    public String getDisabledDatePickerText() {
        return getValue(disabledDatepickerInput);
    }

    public String getEnabledDatePickerText() {
        return getValue(enabledDatepickerInput);
    }

    public void openDisabledDatePicker() {
        clickOn(disabledDatepickerInput);
    }

    public void openEnabledDatePicker() {
        clickOn(enabledDatepickerInput);
    }

    private String getSelectedMonthAndYear() {
        return getText(actualMonthAndYear);
    }

    private YearMonth getSelectedYearMonth() {
        String[] selectedMonthAndYear = getSelectedMonthAndYear().toUpperCase().split(" ");
        Month selectedMonth = Month.valueOf(selectedMonthAndYear[0]);
        int selectedYear = Integer.parseInt(selectedMonthAndYear[1]);
        return YearMonth.of(selectedYear, selectedMonth);
    }

    public void selectYearAndMonth(YearMonth desiredYearMonth) {
        YearMonth selectedYearMonth = getSelectedYearMonth();

        while(!selectedYearMonth.equals(desiredYearMonth)){
            if(selectedYearMonth.isAfter(desiredYearMonth)) {
                selectPrevMonth();
            } else {
                selectNextMonth();
            }
            selectedYearMonth = getSelectedYearMonth();
        }
    }

    public void selectMonth(String month) {
        selectFromDropdownByText(monthDropdown, month);
    }

    public void selectYear(String year) {
        selectFromDropdownByText(yearDropdown, year);
    }

    public void selectDay(String day) {
        clickOn(By.xpath(String.format(dayXPathLocator, day)));
    }
}
