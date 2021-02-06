Feature: Account activity

  Scenario: Account activity page
    Given the user is logged in
    Then Account activity page should be "Zero - Account Activity" displayed
    And Account drop down should have Savings selected
    And Account drop down following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And Transactions table column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
