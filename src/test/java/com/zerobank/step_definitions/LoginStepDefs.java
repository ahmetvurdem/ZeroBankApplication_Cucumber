package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs{

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
       new LoginPage().logInMethod();
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("the user on the login page")
    public void the_user_on_the_login_page() {
        new LoginPage().firstSignInButton.click();
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        String username= ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        new LoginPage().logIn(username,password);
        new LoginPage().backToSafety.click();
        BrowserUtils.waitFor(2);
        new LoginPage().onlineBanking.click();
        new OnlineBankingPage().accountSummary.click();
    }

    @Then("Account summary page should be	displayed")
    public void account_summary_page_should_be_displayed() {
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Zero - Account Summary";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("the user should not be able to login with invalid credentials")
    public void the_user_should_not_be_able_to_login_with_invalid_credentials() {
        String username = "wrong username";
        String password = "wrong password";
        new LoginPage().logIn(username,password);
    }

    @Then("the user should not be able to login with blank username and password")
    public void the_user_should_not_be_able_to_login_with_blank_username_and_password() {
        String username = "";
        String password = "";
        new LoginPage().logIn(username,password);
    }

    @Then("login error message should be displayed")
    public void login_error_message_should_be_displayed() {
        Assert.assertTrue(new LoginPage().errorMessage.isDisplayed());
        System.out.println("new LoginPage().errorMessage.getText() = " + new LoginPage().errorMessage.getText());

    }





}
