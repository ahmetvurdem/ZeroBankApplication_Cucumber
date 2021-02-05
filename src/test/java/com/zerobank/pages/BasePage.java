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




    //****
    @FindBy (id = "account_summary_tab")
    public WebElement accountSummary;

    @FindBy (id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy (id = "transfer_funds_tab")
    public WebElement transferFunds;

    @FindBy (id = "pay_bills_tab")
    public WebElement payBills;

    @FindBy (id = "money_map_tab")
    public WebElement myMoneyMap;

    @FindBy(id = "online_statements_tab")
    public WebElement onlineStatements;
    //****




}
