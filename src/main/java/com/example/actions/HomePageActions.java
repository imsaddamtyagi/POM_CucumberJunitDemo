package com.example.actions;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import com.example.locators.HomePageLocators;
import com.example.utils.HelperClass;

public class HomePageActions {

    HomePageLocators homePageLocators;
    WebDriver driver;

    public HomePageActions() {
        this.driver = HelperClass.getDriver();
        homePageLocators = new HomePageLocators();
        PageFactory.initElements(driver, homePageLocators);
    }

    private WebElement fluentWait(WebElement element, int timeoutSeconds) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .until(driver -> (element != null && element.isDisplayed()) ? element : null);
    }

    // Smart getter with wait
    public String getHomePageText() {
        return fluentWait(homePageLocators.homePageUserName, 10).getText();
    }
}