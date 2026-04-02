package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.FramesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    private FramesPage framesPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.FRAMES);
        framesPage = new FramesPage(driver);
    }

    @Test(testName = "Cambio de foco al single iFrame")
    public void iframeTest(){
        String expectedHeaderTitle = "iFrame Demo", textToSend = "Yo soy groot";
        framesPage.selectSingleIFrameTab();

        framesPage.switchToSingleFrame();
        Assert.assertEquals(framesPage.getHeaderTitle(), expectedHeaderTitle);

        framesPage.sendInputText(textToSend);
        Assert.assertEquals(framesPage.getInputText(), textToSend);

        framesPage.goToDefaultContent();
        Assert.assertTrue(framesPage.isOnFramesPage(), "Error al volver al contenido principal");
    }

    @Test(testName = "Cambio de foco a iFrames anidados")
    public void iframeTest2() {
        String expectedOuterHeaderTitle = "Nested iFrames", expectedInnerHeaderTitle = "iFrame Demo";
        String textToSend = "Yo soy groot";
        framesPage.selectNestedIFramesTab();

        framesPage.switchToOuterFrame();
        Assert.assertEquals(framesPage.getHeaderTitle(), expectedOuterHeaderTitle);

        framesPage.switchToInnerFrame();
        Assert.assertEquals(framesPage.getHeaderTitle(), expectedInnerHeaderTitle);

        framesPage.sendInputText(textToSend);
        Assert.assertEquals(framesPage.getInputText(), textToSend);

        framesPage.goToDefaultContent();
        Assert.assertTrue(framesPage.isOnFramesPage(), "Error al volver al contenido principal");
    }
}
