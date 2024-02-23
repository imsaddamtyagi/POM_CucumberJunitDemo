package com.example.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class LoginPageLocators {
 

	   
    @FindBy(xpath = "//input[@name='email']")
    public WebElement userName;
  
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
     
    @FindBy(xpath = "//div[text()='Something went wrong...']")
    public WebElement missingUsernameErrorMessage;
     
    @FindBy(xpath = "//div[text()='Login']")
    public WebElement LoginBtn;
  
    @FindBy(xpath = "//div[text()='Something went wrong...']")
    public  WebElement errorMessage;
        
}