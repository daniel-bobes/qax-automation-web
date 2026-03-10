package com.danielbobes.demoautomationtesting.steps;

import com.danielbobes.demoautomationtesting.config.DriverManager;
import com.danielbobes.demoautomationtesting.config.GlobalConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initializeDriver();
        DriverManager.maximizeWindow();
        DriverManager.navigateTo(GlobalConfig.URL_DEMO_AUTOMATION_TESTING);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }

}
