package com.danielbobes.web.pages.bonigarcia;

import com.danielbobes.web.enums.MouseAction;
import com.danielbobes.web.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DropDownMenuPage extends BasePage {

    private final String dropdownMenuLocator = "button#%s";
    private final String dropdownMenuLinks = "//button[@id='%s']//following-sibling::ul//a";

    private final By leftClickDropDown = By.cssSelector(String.format(dropdownMenuLocator, "my-dropdown-1"));
    private final By rightClickDropDown = By.cssSelector(String.format(dropdownMenuLocator, "my-dropdown-2"));
    private final By doubleClickDropDown = By.cssSelector(String.format(dropdownMenuLocator, "my-dropdown-3"));

    private final By leftClickDropDownLinks = By.xpath(String.format(dropdownMenuLinks, "my-dropdown-1"));
    private final By rightClickDropDownLinks = By.xpath(String.format(dropdownMenuLinks, "my-dropdown-2"));
    private final By doubleClickDropDownLinks = By.xpath(String.format(dropdownMenuLinks, "my-dropdown-3"));

    public DropDownMenuPage(WebDriver driver) {
        super(driver);
    }

    public void pushOnLeftClickDropDown() {
        pushOn(leftClickDropDown);
    }

    public void pushOnRightClickDropDown() {
        rightClickPushOn(rightClickDropDown);
    }

    public void pushOnDoubleClickDropDown() {
        doublePushOn(doubleClickDropDown);
    }

    public void pushOnDropDown(MouseAction mouseAction) {
        switch (mouseAction) {
            case LEFT_CLICK -> pushOnLeftClickDropDown();
            case RIGHT_CLICK -> pushOnRightClickDropDown();
            case DOUBLE_CLICK -> pushOnDoubleClickDropDown();
        }
    }

    public List<String> getLinks(MouseAction mouseAction) {
        List<WebElement> links = switch (mouseAction) {
            case LEFT_CLICK -> findElements(leftClickDropDownLinks);
            case RIGHT_CLICK -> findElements(rightClickDropDownLinks);
            case DOUBLE_CLICK -> findElements(doubleClickDropDownLinks);
        };

        return links.stream().map(WebElement::getText).toList();
    }

}
