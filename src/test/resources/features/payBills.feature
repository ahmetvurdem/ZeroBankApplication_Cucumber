Feature: Pay Bills
  @wip
  Scenario: successful Pay operation
    Given the user is logged in
    Then Pay Bills page should be "Zero - Pay Bills" displayed
    When user completes a successful Pay operation
      | Amount | 100        |
      | Date   | 2021-02-02 |
    Then The payment was successfully submitted message is displayed

