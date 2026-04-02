package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class WidgetsPage extends BaseDemoQAPage {

    private By widgetsMenu = By.xpath("//a[text()='Widgets']");
    private By subMenuLocator = By.xpath("//a[text()='Widgets']/following-sibling::ul//a");

    private By accordionSubMenu = By.linkText("Accordion");
    private By autocompleteSubMenu = By.linkText("AutoComplete");
    private By datePickerSubMenu = By.linkText("Datepicker");
    private By sliderSubMenu = By.linkText("Slider");

    private By collapse1 = By.id("collapse1");
    private By searchbox = By.id("searchbox");
    private By datepicker1 = By.id("datepicker1");
    private By slider = By.id("slider");

    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverWidgetsMenu() {
        //consentCookies();
        //makeAdsDisappear();
        hoverMenu(widgetsMenu);
    }

    public List<String> getSubMenusText() {
        return findElements(subMenuLocator).stream()
                    .map(webElement -> webElement.getText().trim())
                    .toList();
    }

    public void iterateSubMenus() {
        hoverWidgetsMenu();
        List<String> submenus = getSubMenusText();
        submenus.forEach(submenu -> {
            hoverMenu(widgetsMenu);
            clickOnSubMenu(widgetsMenu, By.linkText(submenu));
        });
    }

    public boolean areSubMenusDisplayed() {
        return !findElements(subMenuLocator).isEmpty();
    }

    private void navigateToSubMenu(By subMenuLocator) {
        hoverMenu(widgetsMenu);
        clickOnSubMenu(widgetsMenu, subMenuLocator);
    }

    public void navigateToAccordion() {
        navigateToSubMenu(accordionSubMenu);
    }

    public void navigateToAutoComplete() {
        navigateToSubMenu(autocompleteSubMenu);
    }

    public void navigateToDatePicker() {
        navigateToSubMenu(datePickerSubMenu);
    }

    public void navigateToSlider() {
        navigateToSubMenu(sliderSubMenu);
    }

    public boolean isOnAccordionPage() {
        return isDisplayed(collapse1);
    }

    public boolean isOnAutoCompletePage() {
        return isDisplayed(searchbox);
    }

    public boolean isOnDatePickerPage() {
        return isDisplayed(datepicker1);
    }

    public boolean isOnSliderPage() {
        return isDisplayed(slider);
    }

}
