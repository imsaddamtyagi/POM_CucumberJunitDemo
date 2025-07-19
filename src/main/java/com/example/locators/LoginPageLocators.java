package com.example.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {
	
	
	public static final By proceed =              By.xpath("//*[@id='details-button']");
	public static final By proceedlink =          By.xpath("//*[@id='proceed-link']");
    public static final By userName =             By.xpath("//input[@name='email']");
    public static final By password =             By.xpath("//input[@name='password']");
    public static final By loginBtn =             By.xpath("//div[text()='Login']");
    public static final By missingUsernameError = By.xpath("//div[text()='Something went wrong...']");
    public static final By errorMessage = By.xpath("//div[text()='Something went wrong...']");
}