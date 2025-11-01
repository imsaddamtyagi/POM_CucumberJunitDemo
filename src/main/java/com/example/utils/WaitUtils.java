package com.example.utils;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 15;
    private static final int DEFAULT_POLLING = 500;

    public static WebElement fluentWait(By locator) 
    {
        return fluentWait(locator, DEFAULT_TIMEOUT);
    }

    public static WebElement fluentWait(By locator, int timeoutSeconds) 
    {
        WebDriver driver = HelperClass.getDriver();
        final int[] successCount = {0};
        long startTime = System.currentTimeMillis();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(DEFAULT_POLLING))
            .ignoring(NoSuchElementException.class);

        WebElement foundElement = wait.until(webDriver -> {
            try {
                WebElement el = webDriver.findElement(locator);
                if (el.isDisplayed()) {
                    successCount[0]++;
                    blinkElement(driver, el); // 🔆 Highlight + blink before return
                    return el;
                }
            } catch (Exception e) {
                // silently ignore
            }
            return null;
        });

        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime) / 1000;

        System.out.println("Locator: " + locator +
            " -> Success count: " + successCount[0] +
            " | Wait time: " + duration + "s");

        return foundElement;
    }
    
    
    
    private static void blinkElement(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            String highlightStyle = "arguments[0].style.border='2px solid red'; arguments[0].style.backgroundColor='yellow'";
            String resetStyle = "arguments[0].style.border=''; arguments[0].style.backgroundColor=''";
            
            for (int i = 0; i < 2; i++) {
                js.executeScript(highlightStyle, element);
                Thread.sleep(50);
                js.executeScript(resetStyle, element);
                Thread.sleep(50);
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("[Blink Error] " + e.getMessage());
        }
    }
}