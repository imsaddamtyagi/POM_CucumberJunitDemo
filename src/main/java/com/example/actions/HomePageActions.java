package com.example.actions;

import com.example.locators.HomePageLocators;
import com.example.utils.WaitUtils;

public class HomePageActions {

    private final int fluentWaitTime = 20;

    public String getHomePageText() {
        return WaitUtils.fluentWait(HomePageLocators.homePageUserName, fluentWaitTime).getText();
    }

    // Add any additional homepage actions below using WaitUtils
}