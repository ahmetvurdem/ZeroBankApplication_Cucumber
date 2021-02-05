package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
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

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshot");
        }
        Driver.closeDriver();
    }


    @Before("@db")
    public void setUpdb(){
        System.out.println("\tconnecting to database...");
    }

    @After("@db")
    public void tearDowndb(){
        System.out.println("\tconnecting to database...");
    }

}
