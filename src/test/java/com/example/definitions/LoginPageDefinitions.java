package com.example.definitions;

import org.junit.Assert;
import com.example.actions.HomePageActions;
import com.example.actions.LoginPageActions;
import com.example.utils.HelperClass;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageDefinitions {

    private LoginPageActions objLogin;
    private HomePageActions objHomePage;

    @Before
    public void setUp() {
        objLogin = new LoginPageActions();
        objHomePage = new HomePageActions();
    }

    @Given("User is on HRMLogin page {string}")
    public void loginTest(String url) {
        HelperClass.openPage(url);
    }

    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) {
        objLogin.login(userName, passWord);
    }

    @Then("User should be able to login successfully and new page open")
    public void verifyLogin() {
        String userText = objHomePage.getHomePageText();
        Assert.assertTrue("Homepage did not contain user text!", userText.contains(userText));
    }

    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        String actualError = objLogin.getErrorMessage();
        Assert.assertEquals("Error message mismatch!", expectedErrorMessage, actualError);
    }

    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
        String actualMessage = objLogin.getMissingUsernameText();
        Assert.assertEquals("Missing username message mismatch!", message, actualMessage);
    }
}