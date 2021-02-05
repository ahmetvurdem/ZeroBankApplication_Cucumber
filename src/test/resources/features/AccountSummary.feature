@wip
Feature: Check specific column in Account Summary Page


  Scenario: Account Summary Page
    Given the user is logged in
    When user click on Account Summary Page link
    Then Account summary page should be	displayed
    And Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |