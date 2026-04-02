package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.WidgetsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverMenuTest extends BaseTest {

    private WidgetsPage widgetsPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL+ GlobalConfig.STATIC);
        widgetsPage = new WidgetsPage(driver);
    }

    @Test(testName = "Desplegar menú principal")
    public void hoverMenuTest() {
        widgetsPage.hoverWidgetsMenu();
        Assert.assertTrue(widgetsPage.areSubMenusDisplayed(),"Deberían mostrarse los submenus");
    }

    @Test(testName = "Recorrer submenus y validar navegación a la página de submenu")
    public void iterateSubMenusTest() {
        widgetsPage.hoverWidgetsMenu();

        widgetsPage.navigateToAccordion();
        Assert.assertTrue(widgetsPage.isOnAccordionPage(), "No estamos en la página Accordion");

        widgetsPage.navigateToAutoComplete();
        Assert.assertTrue(widgetsPage.isOnAutoCompletePage(), "No estamos en la página AutoComplete");

        widgetsPage.navigateToDatePicker();
        Assert.assertTrue(widgetsPage.isOnDatePickerPage(), "No estamos en la página DatePicker");

        widgetsPage.navigateToSlider();
        Assert.assertTrue(widgetsPage.isOnSliderPage(), "No estamos en la página Slider");
    }

}
