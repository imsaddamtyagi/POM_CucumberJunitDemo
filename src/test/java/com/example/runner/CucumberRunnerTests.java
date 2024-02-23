package com.example.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(tags = "", features = "src/test/resources/features/LoginPage.feature",
                 glue = "com.example.definitions",
                 plugin = {"pretty","html:HTMLReports/HTMLReport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 monochrome=true
)
    
public class CucumberRunnerTests {
    
}


