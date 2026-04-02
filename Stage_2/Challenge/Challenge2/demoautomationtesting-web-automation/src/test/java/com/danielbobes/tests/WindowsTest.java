package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WindowsTest extends BaseTest {

    private WindowsPage windowsPage;

    @BeforeMethod
    public void setUp() {
        driver.get(baseURL + GlobalConfig.WINDOWS);
        windowsPage = new WindowsPage(driver);
    }

    @Test(testName = "Abrir nueva pestaña")
    public void openNewTabTest() {
        String expectedMainWindowTitle = "Frames & windows", expectedNewTabTitle = "Selenium";
        windowsPage.selectNewTabbedWindowsTab();

        String currentWindowHandle = driver.getWindowHandle();
        windowsPage.openNewTab();
        windowsPage.switchToNewWindow(currentWindowHandle);

        Assert.assertEquals(windowsPage.getTitle(), expectedNewTabTitle,
                "No estamos en la nueva pestaña o el titúlo no coincide con el esperado.");

        windowsPage.switchToWindow(currentWindowHandle);
        Assert.assertEquals(windowsPage.getTitle(), expectedMainWindowTitle,
                "No estamos en la ventana principal o el titúlo no coincide con el esperado.");
    }

    @Test(testName = "Abrir nueva ventana")
    public void openSeparateWindowTest() {
        String expectedMainWindowTitle = "Frames & windows", expectedNewSeparateWindowTitle = "Selenium";

        windowsPage.selectSeparateWindowsTab();

        String currentWindowHandle = driver.getWindowHandle();
        windowsPage.openSeparateWindow();
        windowsPage.switchToNewWindow(currentWindowHandle);

        Assert.assertEquals(windowsPage.getTitle(), expectedNewSeparateWindowTitle,
                "No estamos en la nueva ventana o el titúlo no coincide con el esperado.");
        windowsPage.closeWindow();

        windowsPage.switchToWindow(currentWindowHandle);
        Assert.assertEquals(windowsPage.getTitle(), expectedMainWindowTitle,
                "No estamos en la ventana principal o el titúlo no coincide con el esperado.");
    }

    @Test(testName = "Abrir múltiples ventanas")
    public void openMultipleWindowsTest() {
        String expectedMainWindowTitle = "Frames & windows";
        List<String> expectedTitles = List.of("Index", "Selenium");

        windowsPage.selectMultipleWindowsTab();

        String currentWindowHandle = driver.getWindowHandle();
        windowsPage.openMultipleWindows();
        windowsPage.switchToNewWindow(currentWindowHandle);

        Assert.assertListContains(expectedTitles, w -> w.equalsIgnoreCase(windowsPage.getTitle()),
                "No estamos en la primera nueva pestaña o el titúlo no coincide con el esperado.");
        windowsPage.closeWindow();

        windowsPage.switchToNewWindow(currentWindowHandle);
        Assert.assertListContains(expectedTitles, w -> w.equalsIgnoreCase(windowsPage.getTitle()),
                "No estamos en la primera nueva pestaña o el titúlo no coincide con el esperado.");
        windowsPage.closeWindow();

        windowsPage.switchToWindow(currentWindowHandle);
        Assert.assertEquals(windowsPage.getTitle(), expectedMainWindowTitle,
                "No estamos en la ventana principal o el titúlo no coincide con el esperado.");
    }

}
