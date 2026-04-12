package com.danielbobes.web.tests.bonigarcia;

import com.danielbobes.web.config.Config;
import com.danielbobes.web.enums.MouseAction;
import com.danielbobes.web.pages.bonigarcia.DropDownMenuPage;
import com.danielbobes.web.tests.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class DropdownMenuTest extends BaseTest {

    @DataProvider(name = "clickTestProvider")
    private Object[][] getClickTestProvider() {
        return new Object[][] {
                {MouseAction.LEFT_CLICK},
                {MouseAction.RIGHT_CLICK},
                {MouseAction.DOUBLE_CLICK}
        };
    }

    @Test(testName = "Dropdown Menú", dataProvider = "clickTestProvider")
    public void mouseActionTest(MouseAction action) {
        driver.get(Config.URL_BONI_GARCIA_DROPDOWN_MENU);

        DropDownMenuPage dropDownMenuPage = new DropDownMenuPage(driver);
        dropDownMenuPage.pushOnDropDown(action);

        List<String> links = dropDownMenuPage.getLinks(action);
        assertEquals("Action", links.getFirst());

        System.out.println("Acción realizada: " + action.getSpanishDescription());
    }
}
