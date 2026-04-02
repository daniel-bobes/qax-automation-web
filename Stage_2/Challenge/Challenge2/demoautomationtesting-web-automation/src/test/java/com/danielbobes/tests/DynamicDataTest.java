package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.DynamicDataPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicDataTest extends BaseTest {

    private DynamicDataPage dynamicDataPage;

    @BeforeMethod
    public void setUp(){
        driver.get(baseURL + GlobalConfig.DYNAMIC_DATA);
        dynamicDataPage = new DynamicDataPage(driver);
    }

    @Test(testName = "Loading Data Dynamically Test")
    public void loadingDataDynamicallyTest() {
        dynamicDataPage.pushOnGetDynamicData();
        String previousLoadingText = dynamicDataPage.getLoadingText();
        dynamicDataPage.pushOnGetDynamicData();
        String newLoadingText = dynamicDataPage.getLoadingText();
        Assert.assertNotEquals(newLoadingText, previousLoadingText,
                "El texto no debería ser igual");
    }
}
