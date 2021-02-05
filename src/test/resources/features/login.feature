Feature: User should be able to login with valid credentials

    Scenario: Login as authorized
        Given the user is on the home page
        Then the user on the login page
        When the user logs in with valid credentials
        Then Account summary page should be	displayed

    Scenario: Try to Login as unauthorized
        Given the user is on the home page
        Then the user on the login page
        When the user should not be able to login with invalid credentials
        Then login error message should be displayed

    Scenario: Try to Login as unauthorized
        Given the user is on the home page
        Then the user on the login page
        And  the user should not be able to login with blank username and password
        Then login error message should be displayed