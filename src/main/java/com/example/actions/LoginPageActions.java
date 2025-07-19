package com.example.actions;

import com.example.locators.LoginPageLocators;
import com.example.utils.WaitUtils;

public class LoginPageActions {

    private final int fluentWaitTime = 20;
    
    
    // 🚪 Click proceed
    public void clickProceed() {
        WaitUtils.fluentWait(LoginPageLocators.proceed, fluentWaitTime).click();
    }
    
    // 🚪 Click proceedLink
    public void clickProceedLink() {
        WaitUtils.fluentWait(LoginPageLocators.proceedlink, fluentWaitTime).click();
    }

    // 🧪 Input username
    public void setUserName(String strUserName) {
        WaitUtils.fluentWait(LoginPageLocators.userName, fluentWaitTime).sendKeys(strUserName);
    }

    // 🔒 Input password
    public void setPassword(String strPassword) {
        WaitUtils.fluentWait(LoginPageLocators.password, fluentWaitTime).sendKeys(strPassword);
    }

    // 🚪 Click login
    public void clickLogin() {
        WaitUtils.fluentWait(LoginPageLocators.loginBtn, fluentWaitTime).click();
    }

    // ❌ Read missing username error
    public String getMissingUsernameText() {
        return WaitUtils.fluentWait(LoginPageLocators.missingUsernameError, fluentWaitTime).getText();
    }

    // ⚠️ Read generic error
    public String getErrorMessage() {
        return WaitUtils.fluentWait(LoginPageLocators.errorMessage, fluentWaitTime).getText();
    }

    // 🔐 Full login sequence
    public void login(String strUserName, String strPassword) {
    	clickProceed();
    	clickProceedLink();
        setUserName(strUserName);
        setPassword(strPassword);
        clickLogin();
    }
}