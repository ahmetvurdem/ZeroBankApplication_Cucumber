package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "signin_button")
    public WebElement firstSignInButton;

    @FindBy(id = "user_login")
    public WebElement userNameInputBox;

    @FindBy(id = "user_password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//input[@name = 'submit']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'alert alert-error']")
    public WebElement errorMessage;

    @FindBy(id = "primary-button")
    public WebElement backToSafety;

    @FindBy (id = "onlineBankingMenu")
    public WebElement onlineBanking;

    @FindBy(id = "account_activity_link")
    public WebElement accountActivityLink;

    public void logIn(String username, String password){
        userNameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        signInButton.click();
    }

    public void logInMethod(){
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        new LoginPage().firstSignInButton.click();
        BrowserUtils.waitFor(2);
        String username= ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        new LoginPage().logIn(username,password);
        new LoginPage().backToSafety.click();
        BrowserUtils.waitFor(2);
        new LoginPage().onlineBanking.click();
    }



}
