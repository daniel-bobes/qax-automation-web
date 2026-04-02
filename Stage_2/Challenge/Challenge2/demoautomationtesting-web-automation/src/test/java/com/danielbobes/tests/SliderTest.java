package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.SliderPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    private SliderPage sliderPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.SLIDER);
        sliderPage = new SliderPage(driver);
    }

    @Test(testName = "Slider Test")
    public void sliderTest() {
        int horizontalOffset = 335;
        sliderPage.moveSlider(horizontalOffset);

        Assert.assertTrue(sliderPage.getLeftPropertyValue() >= horizontalOffset,
                "El slider no esta en la posición esperada");
    }

}
