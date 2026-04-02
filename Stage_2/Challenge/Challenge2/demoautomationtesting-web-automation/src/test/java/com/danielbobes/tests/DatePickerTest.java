package com.danielbobes.tests;

import com.danielbobes.utils.DateUtils;
import com.danielbobes.utils.StringUtils;
import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.DatePickerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;

public class DatePickerTest extends BaseTest {

    private DatePickerPage datePickerPage;

    @BeforeMethod
    public void setUp(){
        driver.get(baseURL + GlobalConfig.DATE_PICKER);
        datePickerPage = new DatePickerPage(driver);
    }

    @Test(testName = "DatePicker Disabled Test")
    public void disabledDatePickerTest() {
        LocalDate myBirthDate = LocalDate.of(1992, Month.JUNE, 9);
        String dateFormatted = DateUtils.formatDate(myBirthDate);
        YearMonth desiredYearMonth = YearMonth.of(myBirthDate.getYear(), myBirthDate.getMonthValue());

        datePickerPage.openDisabledDatePicker();
        datePickerPage.selectYearAndMonth(desiredYearMonth);
        datePickerPage.selectDay(String.valueOf(myBirthDate.getDayOfMonth()));
        Assert.assertEquals(datePickerPage.getDisabledDatePickerText(), dateFormatted,
                "Las fechas deberían ser iguales");
    }

    @Test(testName = "DatePicker Enabled Test - Filling input")
    public void fillDateInEnabledDatePickerTest() {
        LocalDate myBirthDate = LocalDate.of(1992, Month.JUNE, 9);
        String dateFormatted = DateUtils.formatDate(myBirthDate);

        datePickerPage.fillEnabledDatePicker(dateFormatted);
        Assert.assertEquals(datePickerPage.getEnabledDatePickerText(), dateFormatted,
                "Las fechas deberían ser iguales");
    }

    @Test(testName = "DatePicker Enabled Test - Select date")
    public void selectDateInEnabledDatePickerTest() {
        LocalDate date = LocalDate.of(2024, Month.JUNE, 24);

        datePickerPage.openEnabledDatePicker();

        datePickerPage.selectMonth(StringUtils.capitalize(date.getMonth().toString()));
        datePickerPage.selectYear(String.valueOf(date.getYear()));
        datePickerPage.selectDay(String.valueOf(date.getDayOfMonth()));

        Assert.assertEquals(datePickerPage.getEnabledDatePickerText(), DateUtils.formatDate(date),
                "Las fechas deberían ser iguales");
    }

}
