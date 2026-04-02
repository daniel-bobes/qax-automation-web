package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DragAndDropPage extends BasePage {

    private final By angularImage = By.cssSelector("#dragarea #angular");
    private final By mongoImage = By.cssSelector("#dragarea #mongo");
    private final By nodeImage = By.cssSelector("#dragarea #node");
    private final By dropArea = By.cssSelector("div#droparea");
    private final By imagesInDropArea = By.cssSelector("div#droparea img");

    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    public void dragAndDrop() {
        consentCookies();
        makeAdsDisappear();

        List<By> images = Arrays.asList(angularImage, mongoImage, nodeImage);
        Collections.shuffle(images);
        dragAndDrop(images.getFirst(), dropArea);
    }

    public int getImagesInDropArea() {
        return findElements(imagesInDropArea).size();
    }

}
