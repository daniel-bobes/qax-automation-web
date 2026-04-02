package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SliderPage extends BaseDemoQAPage {

    private final By sliderComponent = By.xpath("//div[@id='slider']//a");

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSlider(int horizontalOffset) {
        moveHorizontalSlider(sliderComponent, horizontalOffset);
    }

    public Double getLeftPropertyValue() {
        return Double.parseDouble(getCssValue(sliderComponent, "left").replace("px", ""));
    }

    public String getStyle() {
        return getAttribute(sliderComponent, "style");
    }

}
