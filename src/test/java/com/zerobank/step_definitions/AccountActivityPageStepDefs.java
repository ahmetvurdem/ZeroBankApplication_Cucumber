package com.zerobank.step_definitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class AccountActivityPageStepDefs {

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedTitle = "Account Activity";
        String title = Driver.get().getTitle();
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
        System.out.println("title = " + title);
    }

    @Then("Account activity page should be {string} displayed")
    public void account_activity_page_should_be_displayed(String expectedTitle) {
        BrowserUtils.waitFor(2);
        new LoginPage().accountActivityLink.click();
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Then("Account drop down following options")
    public void account_drop_down_following_options(List<String> currentOptions) {
        BrowserUtils.waitFor(2);

        List<String> actualOptions = new AccountActivityPage().allCurrencyDropDownElements();

        System.out.println("new AccountActivityPage().allCurrencyDropDownElements() = " + new AccountActivityPage().allCurrencyDropDownElements());
        System.out.println("currentOptions = " + currentOptions);

        Assert.assertTrue(actualOptions.containsAll(currentOptions));
    }

    @Then("Transactions table column names")
    public void transactions_table_column_names(List<String> accountActivityHeader) {
        BrowserUtils.waitFor(2);
        List<String> actualAccountActivityHeader = BrowserUtils.getElementsText(new AccountActivityPage().actualAccountActivityHead);
        Assert.assertEquals( accountActivityHeader,actualAccountActivityHeader);
        System.out.println("accountActivityHeader = " + accountActivityHeader);
        System.out.println("BrowserUtils.getElementsText(new AccountActivityPage().actualAccountActivityHead) = " + BrowserUtils.getElementsText(new AccountActivityPage().actualAccountActivityHead));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String selectedDropdown) {
        Assert.assertEquals(selectedDropdown, new AccountActivityPage().getFirtSelectedOptions());
    }

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new LoginPage().logInMethod();
        new LoginPage().accountActivityLink.click();
        new AccountActivityPage().findTransactionsTab.click();
        BrowserUtils.waitFor(3);
    }

    @Given("clicks search")
    public void clicks_search() {
        new AccountActivityPage().clickButton.click();
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String online) {
        BrowserUtils.waitFor(2);
        new AccountActivityPage().descriptionInputBox.clear();
        new AccountActivityPage().descriptionInputBox.sendKeys(online);
        BrowserUtils.waitFor(2);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String finishDate) {
        new AccountActivityPage().startDate.sendKeys(startDate);
        new AccountActivityPage().finishDate.sendKeys(finishDate);
    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        Select stateDropdown = new Select(new AccountActivityPage().typeDropDown);
        stateDropdown.selectByVisibleText(type);
        BrowserUtils.waitFor(2);
        new AccountActivityPage().clickButton.click();
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String online) {
        new AccountActivityPage().allDescriptionColumn(online);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String type) {
        new AccountActivityPage().notContainsDescriptionColumn(type);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String header) {
       switch (header){
           case "Deposit":
            new AccountActivityPage().allDepositColumnsEmpty();
               break;
           case "Withdrawal":
            new AccountActivityPage().allWithdrawalColumnsEmpty();
               break;
       }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String header) {
        switch (header){
            case "Deposit":
                new AccountActivityPage().atLeastOneResultUnderDeposit();
                break;
            case "Withdrawal":
                new AccountActivityPage().atLeastOneResultUnderWithdraw();
                break;
        }
    }


}
