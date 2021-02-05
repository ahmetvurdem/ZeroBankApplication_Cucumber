package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.When;

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


}
