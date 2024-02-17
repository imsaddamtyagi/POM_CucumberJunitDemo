package com.example.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class HomePageLocators {
 
      @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")
      public  WebElement homePageUserName;
       
}