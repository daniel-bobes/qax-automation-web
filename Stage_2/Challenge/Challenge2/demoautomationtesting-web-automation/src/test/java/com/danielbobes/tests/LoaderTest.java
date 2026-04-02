package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.LoaderPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoaderTest extends BaseTest {

    private LoaderPage loaderPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.LOADER);
        loaderPage = new LoaderPage(driver);
    }

    @Test
    public void loaderTest() {
        loaderPage.pushOnRun();
        Assert.assertTrue(loaderPage.isLoaderVisible(), "El loader debería ser visible");
        loaderPage.waitForLoaderToClose();
        Assert.assertTrue(loaderPage.isModalVisible(), "El modal debería ser visible");
    }
}
