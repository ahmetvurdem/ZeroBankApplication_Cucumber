package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage extends BasePage{

    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (id = "aa_accountId")
    public WebElement accountDropDown;

    public String getFirtSelectedOptions(){
        Select stateDropdown = new Select(accountDropDown);
        return stateDropdown.getFirstSelectedOption().getText();
    }
}
