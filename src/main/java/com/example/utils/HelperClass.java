package com.example.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperClass {

    private static HelperClass instance;
    private static WebDriver driver;
    private static final int PAGE_LOAD_TIMEOUT = 10;

    private HelperClass() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
    }

    public static void setUpDriver() {
        if (instance == null) {
            instance = new HelperClass();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void openPage(String url) {
        driver.get(url);
    }

    public static void tearDown() {
        if (driver != null) {
            //driver.quit();
            driver = null;
        }
        instance = null;
    }
}