package com.danielbobes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalsPage extends BaseDemoQAPage {

    private final String commonLocator = "//div[text()='%s']/following-sibling::div/a[text()='Launch modal']";

    private final By launchBootstrapModal = By.xpath(String.format(commonLocator, "Bootstrap Modal"));
    private final By launchMultipleModals = By.xpath(String.format(commonLocator, "Multiple Modals"));

    private final By boostrapModal = By.xpath("//div[@id='myModal']");
    private final By firstModal = By.xpath("//div[@id='myModalMulti']");
    private final By secondModal = By.xpath("//div[@id='myModal2']");

    private final By closeBootstrapModalButton = By.xpath("//div[@class='modal-footer']/button[text()='Close']");
    private final By closeFirstModalButton = By.xpath("//div[@id='myModalMulti']//div[@class='modal-footer']/a[text()='Close']");
    private final By openSecondModalButton = By.xpath("//div[@id='myModalMulti']//a[text()='Launch modal']");
    private final By closeSecondModalButton = By.xpath("//div[@id='myModal2']//div[@class='modal-footer']/a[text()='Close']");

    public ModalsPage(WebDriver driver) {
        super(driver);
    }

    public void pushOnLaunchBootstrapModal() {
        clickOn(launchBootstrapModal);
    }

    public void pushOnLaunchMultipleModals() {
        clickOn(launchMultipleModals);
    }

    public boolean isBoostrapModalDisplayed() {
        return isDisplayed(boostrapModal);
    }

    public boolean isFirstModalDisplayed() {
        return isDisplayed(firstModal);
    }

    public boolean isSecondModalDisplayed() {
        return isDisplayed(secondModal);
    }

    public void closeBootstrapModal() {
        clickOn(closeBootstrapModalButton);
        waitToVanish(boostrapModal);
    }

    public void pushOnLaunchSecondModal() {
        clickOn(openSecondModalButton);
    }

    public void closeSecondModal() {
        clickOn(closeSecondModalButton);
        waitToVanish(secondModal);
    }

    public void closeFirstModal() {
        clickOn(closeFirstModalButton);
        waitToVanish(firstModal);
    }
}
