package com.example.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class LoginPageLocators {
 
    @FindBy(xpath = "//input[@name= 'username']")
    public WebElement userName;
  
    @FindBy(xpath = "//input[@name= 'password']")
    public WebElement password;
     
    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")
    public WebElement missingUsernameErrorMessage;
     
    @FindBy(xpath = "//button[@type= 'submit']")
    public WebElement login;
  
    @FindBy(xpath = "//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")
    public  WebElement errorMessage;
        
}