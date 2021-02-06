package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineBankingPage extends BasePage{

    public OnlineBankingPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "account_summary_link")
    public WebElement accountSummary;

    @FindBy (id = "pay_bills_link")
    public WebElement payBills;




}
