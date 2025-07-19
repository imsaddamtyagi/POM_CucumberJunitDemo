package com.example.definitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.example.utils.HelperClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp() {
        HelperClass.setUpDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            TakesScreenshot ts = (TakesScreenshot) HelperClass.getDriver();
            final byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Scenario Screenshot: " + scenario.getName());
            System.out.println("[Screenshot attached for]: " + scenario.getName());
        } catch (Exception e) {
            System.out.println("[Screenshot Error] " + e.getMessage());
        }

        HelperClass.tearDown();
        System.out.println("[Driver teardown complete]");
    }
}