package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage{

    public PayBillsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeNameInputBox;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAddressInputBox;

    @FindBy(id = "np_new_payee_account")
    public WebElement accountInputBox;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeDetailsInputBox;

    @FindBy (id = "add_new_payee")
    public WebElement addButton;

    @FindBy (id = "alert_content")
    public WebElement message;

    @FindBy (xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy (id = "pc_currency")
    public WebElement currencyDropDown;

    @FindBy (id = "pc_amount")
    public WebElement amount;

    @FindBy (id = "purchase_cash")
    public WebElement purchaseButton;



    public void addPayee(String payeeNameStr, String payeeAddressStr, String accountStr, String payeeDetailsStr){
        payeeNameInputBox.sendKeys(payeeNameStr);
        payeeAddressInputBox.sendKeys(payeeAddressStr);
        accountInputBox.sendKeys(accountStr);
        payeeDetailsInputBox.sendKeys(payeeDetailsStr);
        addButton.click();
    }

    public List<String> allCurrencyDropDownElements(){
        Select stateDropdown = new Select(currencyDropDown);
        List<WebElement> currencyOptions = stateDropdown.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(currencyOptions);
        return elementsText;
    }




}
