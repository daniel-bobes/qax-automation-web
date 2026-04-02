package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.ProgressBarPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProgressBarTest extends BaseTest {

    private ProgressBarPage progressBarPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.PROGRESS_BAR);
        progressBarPage = new ProgressBarPage(driver);
    }

    @Test
    public void progressBarTest() {
        String expectedText = "100";
        progressBarPage.pushOnDownload();
        progressBarPage.waitForProgressBarToComplete();
        Assert.assertEquals(progressBarPage.getProgressBarText(), expectedText,
                "La barra de progreso no ha terminado de cargar");
    }
}
