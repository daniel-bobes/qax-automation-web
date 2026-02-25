package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.config.enums.MouseClick;
import com.danielbobes.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class DropdownMenuTest extends BaseTest {

    @DataProvider(name = "clickTestProvider")
    private Object[][] getClickTestProvider() {
        return new Object[][] {
                {"my-dropdown-1", MouseClick.LEFT_CLICK},
                {"my-dropdown-2", MouseClick.RIGHT_CLICK},
                {"my-dropdown-3", MouseClick.DOUBLE_CLICK}
        };
    }

    @Test(testName = "Dropdown Menú - {action}", dataProvider = "clickTestProvider")
    public void leftClickTest(String id, MouseClick action) {
        driver.get(Config.URL_BONI_GARCIA_DROPDOWN_MENU);

        String dropdownMenuLocator = "button#%s";
        WebElement dropDownMenu = driver.findElement(By.cssSelector(String.format(dropdownMenuLocator, id)));

        Actions actions = new Actions(driver);
        switch (action) {
            case LEFT_CLICK -> actions.click(dropDownMenu).perform();
            case RIGHT_CLICK -> actions.contextClick(dropDownMenu).perform();
            case DOUBLE_CLICK -> actions.doubleClick(dropDownMenu).perform();
        }

        String dropdownMenuLinks = "//button[@id='%s']//following-sibling::ul//a";
        List<WebElement> links = driver.findElements(By.xpath(String.format(dropdownMenuLinks, id)));
        assertEquals("Action", links.getFirst().getText());

        System.out.println("Acción realizada: " + action.getSpanishDescription());
    }
}
