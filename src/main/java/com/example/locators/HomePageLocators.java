package com.example.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class HomePageLocators {
 
      @FindBy(xpath = "//*[@id='top-header-menu']/div[2]/span[1]")
      public  WebElement homePageUserName;
       
}