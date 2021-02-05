package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
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

    public String getFirtSelectedOptions(){
        Select stateDropdown = new Select(accountDropDown);
        return stateDropdown.getFirstSelectedOption().getText();
    }

    public List<String> allCurrencyDropDownElements(){
        Select stateDropdown = new Select(accountDropDown);
        List<WebElement> currencyOptions = stateDropdown.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(currencyOptions);
        return elementsText;
    }
}
