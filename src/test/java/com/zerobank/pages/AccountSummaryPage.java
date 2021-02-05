package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[text()='Savings']")
    public WebElement savingsLink;

    @FindBy(xpath = "//*[text()='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//*[text()='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//a[text()='Credit Card']")
    public WebElement creditCardLink;

    @FindBy(xpath = "//*[text()='Loan']")
    public WebElement loanLink;

    @FindBy(xpath = "//h2[@class = 'board-header']")
    public List<WebElement> countTypes;

    @FindBy (xpath = "(//table[@class = 'table'])[3]/thead/tr/th")
    public List<WebElement> creditAccountHead;

}


















