package com.example.utils;

//import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class HelperClass {
 
     private static HelperClass helperClass;
      
        private static WebDriver driver;
       // public final static int TIMEOUT = 1;
           
         private HelperClass() {
                
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        //    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            
         }      
                   
        public static void openPage(String url) {
            driver.get(url);
        }
               
        public static WebDriver getDriver() {
            return driver;              
        }
           
        public static void setUpDriver() {
               
            if (helperClass==null) {
                   
                helperClass = new HelperClass();
            }
        }
           
        public static void tearDown() {
                
            if(driver!=null) {
                // driver.close();
                 //driver.quit();
            }
                
           helperClass = null;
       } 
           
    }