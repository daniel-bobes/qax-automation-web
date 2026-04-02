package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.ModalsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModalsTest extends BaseTest {

    private ModalsPage modalsPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.MODALS);
        modalsPage = new ModalsPage(driver);
    }

    @Test
    public void launchBootstrapModalTest() {
        modalsPage.pushOnLaunchBootstrapModal();
        Assert.assertTrue(modalsPage.isBoostrapModalDisplayed(), "El modal debería ser visible");
        modalsPage.closeBootstrapModal();
        Assert.assertFalse(modalsPage.isBoostrapModalDisplayed(), "El modal no debería ser visible");
    }

    @Test
    public void launchMultipleModalsTest() {
        modalsPage.pushOnLaunchMultipleModals();
        Assert.assertTrue(modalsPage.isFirstModalDisplayed(), "El primer modal debería ser visible");
        modalsPage.pushOnLaunchSecondModal();
        Assert.assertTrue(modalsPage.isSecondModalDisplayed(), "El segundo modal debería ser visible");
        modalsPage.closeSecondModal();
        Assert.assertFalse(modalsPage.isSecondModalDisplayed(), "El segundo modal no debería ser visible");
        modalsPage.closeFirstModal();
        Assert.assertFalse(modalsPage.isFirstModalDisplayed(), "El primer modal no debería ser visible");
    }
}
