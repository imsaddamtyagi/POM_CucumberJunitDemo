package com.example.actions;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import com.example.locators.LoginPageLocators;
import com.example.utils.HelperClass;

public class LoginPageActions {

    LoginPageLocators loginPageLocators = null;
    WebDriver driver;

    public LoginPageActions() {
        this.driver = HelperClass.getDriver();
        loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(driver, loginPageLocators);
    }

    
    private WebElement fluentWait(WebElement element, int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class);

        return wait.until(webDriver -> element.isDisplayed() ? element : null);
    }
    
    
    

    public void setUserName(String strUserName) {
        fluentWait(loginPageLocators.userName, 10).sendKeys(strUserName);
    }

    public void setPassword(String strPassword) {
        fluentWait(loginPageLocators.password, 10).sendKeys(strPassword);
    }

    public void clickLogin() {
        fluentWait(loginPageLocators.LoginBtn, 10).click();
    }

    public String getMissingUsernameText() {
        return fluentWait(loginPageLocators.missingUsernameErrorMessage, 10).getText();
    }

    public String getErrorMessage() {
        return fluentWait(loginPageLocators.errorMessage, 10).getText();
    }

    public void login(String strUserName, String strPassword) {
        setUserName(strUserName);
        setPassword(strPassword);
        clickLogin();
    }
}