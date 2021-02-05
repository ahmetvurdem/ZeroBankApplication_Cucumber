package com.zerobank.step_definitions;

import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class PayBillPageStepDefs{


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new OnlineBankingPage().payBills.click();
        BrowserUtils.waitFor(2);
        new PayBillsPage().addNewPayee.click();
        BrowserUtils.waitFor(2);
    }

    @And("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInfo) {
        new PayBillsPage().addPayee(payeeInfo.get("Payee Name"), payeeInfo.get("Payee Address"), payeeInfo.get("Account"),payeeInfo.get("Payee details"));
    }

    @Then("message The new payee The Law Office of Hyde, Price & Scharks eas successfully created. should be  displayed")
    public void message_The_new_payee_The_Law_Office_of_Hyde_Price_Scharks_eas_successfully_created_should_be_displayed() {
        new PayBillsPage().message.isDisplayed();
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        new OnlineBankingPage().payBills.click();
        BrowserUtils.waitFor(2);
        new PayBillsPage().purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyDropDown) {
        BrowserUtils.waitFor(3);
        new PayBillsPage().allCurrencyDropDownElements().contains(currencyDropDown);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitFor(3);
        new Select(new PayBillsPage().currencyDropDown).selectByIndex(3);
        new PayBillsPage().purchaseButton.click();
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitFor(3);
        new PayBillsPage().amount.sendKeys("100");
        new PayBillsPage().purchaseButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        BrowserUtils.waitFor(3);
        Alert alert = Driver.get().switchTo().alert();
        Assert.assertFalse(alert.getText().isEmpty());

    }

}

