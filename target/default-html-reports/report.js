$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/AccountActivityNavigation.feature");
formatter.feature({
  "name": "Navigating to specific accounts in Accounts Activity",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Savings account redirect",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on Savings link on the Account Summary page",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_user_clicks_on_Savings_link_on_the_Account_Summary_page()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\n\tat com.zerobank.step_definitions.LoginStepDefs.the_user_clicks_on_Savings_link_on_the_Account_Summary_page(LoginStepDefs.java:31)\n\tat ✽.the user clicks on Savings link on the Account Summary page(file:///Users/ahmetvurdem/IdeaProjects/ZeroBankApplication_Cucumber/src/test/resources/features/AccountActivityNavigation.feature:6)\n",
  "status": "pending"
});
formatter.step({
  "name": "the Account Activity page should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.the_Account_Activity_page_should_be_displayed()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Account drop down should have Savings selected",
  "keyword": "And "
});
formatter.match({
  "location": "com.zerobank.step_definitions.LoginStepDefs.account_drop_down_should_have_Savings_selected()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});