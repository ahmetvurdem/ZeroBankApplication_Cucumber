package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

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



    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String pageName) {
        new OnlineBankingPage().accountSummary.click();
        switch (pageName) {
            case "Savings":
                new AccountSummaryPage().savingsLink.click();
                break;
            case "Checking":
                new AccountSummaryPage().checkingLink.click();
                break;
            case "Brokerage":
                new AccountSummaryPage().brokerageLink.click();
                break;
            case "Credit card":
                new AccountSummaryPage().creditCardLink.click();
                break;
            case "Loan":
                new AccountSummaryPage().loanLink.click();
                break;
        }
    }

}
