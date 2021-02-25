@smoke
Feature: Pay Bills

  Background:
    Given the user is logged in
    Then Pay Bills page should be "Zero - Pay Bills" displayed

  Scenario: successful Pay operation
    When user completes a successful Pay operation
      | Amount | 100        |
      | Date   | 2021-02-02 |
    Then The payment was successfully submitted message is displayed

  Scenario: Failed Pay operation
    When user tries to make a payment without entering the amount
      | Date   | 2021-02-02 |
    Then The payment was failed and fail message is displayed on amount input box

  Scenario: Failed Pay operation
    When user tries to make a payment without entering the date
      | Amount | 100        |
    Then The payment was failed and fail message is displayed on date input box





