package com.danielbobes.tests;

import com.danielbobes.web.config.GlobalConfig;
import com.danielbobes.web.pages.AlertsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {

    private static AlertsPage alerts;

    @BeforeMethod
    public void setUp(){
        driver.get(baseURL + GlobalConfig.ALERTS);
        alerts = new AlertsPage(driver);
    }

    @Test(testName = "Alerta simple", priority = 1)
    public void simpleAlertTest() {
        alerts.openSimpleAlert();
        alerts.handleAlert(true);
        Assert.assertTrue(alerts.isConfirmResultTextInvisible(),
                "No debería mostrarse ningún resultado");
        Assert.assertTrue(alerts.isPromptResultTextInvisible(),
                "No debería mostrarse ningún resultado");
    }

    @Test(testName = "Aceptar alerta de confirmación", priority = 2)
    public void acceptConfirmAlertTest() {
        String expectedText = "You pressed Ok";
        alerts.openConfirmAlert();
        alerts.handleAlert(true);
        Assert.assertEquals(alerts.getConfirmAlertResultText(), expectedText,
                "El resultado no coincide con el valor esperado");
    }

    @Test(testName = "Cancelar alerta de confirmación", priority = 3)
    public void cancelConfirmAlertTest() {
        String expectedText = "You Pressed Cancel";
        alerts.openConfirmAlert();
        alerts.handleAlert(false);
        Assert.assertEquals(alerts.getConfirmAlertResultText(), expectedText,
                "El resultado no coincide con el valor esperado");
    }

    @Test(testName = "Alert de prompt", priority = 4)
    public void promptAlertTest() {
        String expectText = "Hello %s How are you today";
        String testText = "Texto de prueba";
        alerts.openPromptAlert();
        alerts.handleAlert(true, testText);
        Assert.assertTrue(alerts.getPromptAlertResultText().contains(testText),
            "El mensaje no contiene el texto informado en la alerta.");
        Assert.assertEquals(alerts.getPromptAlertResultText(), String.format(expectText, testText),
                "El resultado no coincide con el valor esperado.");
    }

}
