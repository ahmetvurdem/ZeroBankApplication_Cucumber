package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//table[@class = 'table table-condensed table-hover']/thead/tr/th")
    public List<WebElement> actualAccountActivityHead;

    @FindBy (id = "aa_accountId")
    public WebElement accountDropDown;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactionsTab;

    @FindBy(xpath = "//button[@class = 'btn btn-primary']")
    public WebElement clickButton;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy (id = "aa_fromDate")
    public WebElement startDate;

    @FindBy (id = "aa_toDate")
    public WebElement finishDate;

    @FindBy (id = "aa_type")
    public WebElement typeDropDown;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[2]")
    public List<WebElement> descriptionColumn;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[3]")
    public List<WebElement> depositColumn;

    @FindBy (xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr/td[4]")
    public List<WebElement> withdrawColumn;





    public String getFirtSelectedOptions(){
        Select stateDropdown = new Select(accountDropDown);
        return stateDropdown.getFirstSelectedOption().getText();
    }

    public List<String> allCurrencyDropDownElements(){
        Select stateDropdown = new Select(accountDropDown);
        List<WebElement> currencyOptions = stateDropdown.getOptions();
        return BrowserUtils.getElementsText(currencyOptions);
    }

    public void allDescriptionColumn(String param){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = descriptionColumn;
        for (WebElement element : elements) {
            System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains(param));
        }
    }

    public void allDepositColumnsEmpty(){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = depositColumn;
        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().isEmpty());
        }
    }

    public void allWithdrawalColumnsEmpty(){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = withdrawColumn;
        for (WebElement element : elements) {
            Assert.assertTrue(element.getText().isEmpty());
        }
    }

    public void atLeastOneResultUnderDeposit(){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = depositColumn;
        String dummy ="";
        for (WebElement element : elements) {
            if (element.getText().isEmpty()){

            }else{
                dummy = element.getText();
            }
        }

        Assert.assertFalse(dummy.isEmpty());
    }

    public void atLeastOneResultUnderWithdraw(){
        BrowserUtils.waitFor(2);
        List<WebElement> elements = withdrawColumn;
        String dummy ="";
        for (WebElement element : elements) {
            if (element.getText().isEmpty()){

            }else{
                dummy = element.getText();
            }
        }
        Assert.assertFalse(dummy.isEmpty());
    }
}
