package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (css = ".brand")
    public WebElement pageSubTitle;

    @FindBy (id = "searchTerm")
    public WebElement searchInputBox;

    @FindBy (css = "(//a[@class = 'dropdown-toggle'])[2]")
    public WebElement username;

    @FindBy (id = "logout_link")
    public WebElement logOutLink;

    public String getPageSubTitle(){
        return pageSubTitle.getText();
    }

}
