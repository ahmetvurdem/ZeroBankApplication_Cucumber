package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        new OnlineBankingPage().accountSummary.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().savingsLink.click();
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new OnlineBankingPage().accountSummary.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().brokerageLink.click();
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new OnlineBankingPage().accountSummary.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().checkingLink.click();
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new OnlineBankingPage().accountSummary.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().creditCardLink.click();
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new OnlineBankingPage().accountSummary.click();
        BrowserUtils.waitFor(3);
        new AccountSummaryPage().loanLink.click();
    }

    @When("user click on Account Summary Page link")
    public void user_click_on_Account_Summary_Page_link() {
       new OnlineBankingPage().accountSummary.click();
    }

    @Then("Account summary page should have to following account types")
    public void account_summary_page_should_have_to_following_account_types(List<String> accountTypes) {
        List<String> actualAccount = BrowserUtils.getElementsText(new AccountSummaryPage().countTypes);
        Assert.assertEquals(accountTypes,actualAccount);
    }

    @Then("Credit Accounts table must have columns")
    public void credit_Accounts_table_must_have_columns(List<String> creditAccountHeader) {
        List<String> actualCreditAccountHeader = BrowserUtils.getElementsText(new AccountSummaryPage().creditAccountHead);
        Assert.assertEquals(creditAccountHeader,actualCreditAccountHeader);
    }


}
