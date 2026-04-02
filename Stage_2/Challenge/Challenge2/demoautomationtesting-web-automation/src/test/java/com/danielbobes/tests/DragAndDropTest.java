package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    private DragAndDropPage staticPage;

    @BeforeMethod
    public void setUp() {
        staticPage = new DragAndDropPage(driver);
    }

    @Test(testName = "Validación de drag and drop estático")
    public void staticDragAndDropTest() {
        driver.get(baseURL + GlobalConfig.STATIC);
        staticPage.dragAndDrop();
        Assert.assertTrue(staticPage.getImagesInDropArea() > 0,
                "El número de imágenes en la drop area debería ser mayor que 0");
    }

    @Test(testName = "Validación de drag and drop dinámico")
    public void dynamicDragAndDropTest() {
        driver.get(baseURL + GlobalConfig.DYNAMIC);
        staticPage.dragAndDrop();
        Assert.assertTrue(staticPage.getImagesInDropArea() > 0,
                "El número de imágenes en la drop area debería ser mayor que 0");
    }

}
