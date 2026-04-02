package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.AccordionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccordionTest extends BaseTest {

    private AccordionPage accordionPage;

    @BeforeMethod
    public void setUp(){
        driver.get(baseURL + GlobalConfig.ACCORDION);
        accordionPage = new AccordionPage(driver);
    }

    @Test
    public void accordionTest() {
        Assert.assertTrue(accordionPage.isFirstCollapseDisplayed(),
                "El primer panel debería ser visible");

        accordionPage.pushOnReadability();
        Assert.assertFalse(accordionPage.isFirstCollapseDisplayed(),
                "El primer panel no debería ser visible");

        accordionPage.pushOnSingleLineCoding();
        Assert.assertTrue(accordionPage.isSecondCollapseDisplayed(),
                "El segundo panel debería ser visible");

        accordionPage.pushOnMethodChaining();
        Assert.assertTrue(accordionPage.isThirdCollapseDisplayed(),
                "El tercer panel debería ser visible");

        accordionPage.pushOnCrossBowserTesting();
        Assert.assertTrue(accordionPage.isFourthCollapseDisplayed(),
                "El cuarto panel debería ser visible");

        accordionPage.waitSeconds(5);
    }

}
