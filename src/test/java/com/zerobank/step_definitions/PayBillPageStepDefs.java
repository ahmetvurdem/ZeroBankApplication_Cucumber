package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
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

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Map;

public class PayBillPageStepDefs{


    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        new LoginPage().logInMethod();
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
        new LoginPage().logInMethod();
        BrowserUtils.waitFor(2);
        new OnlineBankingPage().payBills.click();
        BrowserUtils.waitFor(2);
        new PayBillsPage().purchaseForeignCurrencyTab.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyDropDown) {
        BrowserUtils.waitFor(3);
        new PayBillsPage().allCurrencyDropDownElements().containsAll(currencyDropDown);
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

    @Then("Pay Bills page should be {string} displayed")
    public void pay_Bills_page_should_be_displayed(String zeroPayBillsTitle) {
        BrowserUtils.waitFor(2);
        new OnlineBankingPage().payBills.click();
        String actualPayBillsTitle = Driver.get().getTitle();
        Assert.assertEquals(zeroPayBillsTitle,actualPayBillsTitle);
    }

    @When("user completes a successful Pay operation")
    public void user_completes_a_successful_Pay_operation(Map<String,String> payeeInfo) {
        new PayBillsPage().paySavedPee(payeeInfo.get("Amount") , payeeInfo.get("Date"));
    }

    @Then("The payment was successfully submitted message is displayed")
    public void the_payment_was_successfully_submitted_message_is_displayed() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new PayBillsPage().successfulMessage.isDisplayed());
    }

    @When("user tries to make a payment without entering the amount")
    public void user_tries_to_make_a_payment_without_entering_the_amount(Map<String,String> inputs) {
      new PayBillsPage().sendDateInput(inputs.get("Date"));
    }

    @When("user tries to make a payment without entering the date")
    public void user_tries_to_make_a_payment_without_entering_the_date(Map<String,String> inputs) {
       new PayBillsPage().sendAmountInput(inputs.get("Amount"));
    }

    @Then("The payment was failed and fail message is displayed on date input box")
    public void the_payment_was_failed_and_fail_message_is_displayed_on_date_input_box() {
        String message = new PayBillsPage().dateInputBox.getAttribute("validationMessage");
        System.out.println("message = " + message);
        Assert.assertFalse(message.isEmpty());
    }

    @Then("The payment was failed and fail message is displayed on amount input box")
    public void the_payment_was_failed_and_fail_message_is_displayed_on_amount_input_box() {
        String displayMessage = "Please fill out this field.";
        String message = new PayBillsPage().amountInputBox.getAttribute("validationMessage");
        System.out.println("message = " + message);
        Assert.assertEquals(displayMessage,message);
    }


}

