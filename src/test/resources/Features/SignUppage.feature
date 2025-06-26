@E2E
Feature: New User SignUp

  Background:
    Given the user is on Automation Exercise page

  Scenario: Fill the User SignUp page
    Given user click Signup_login link and SignUp page should display
    When user enter the name and email address
    And click on SignUp button
    Then the user should see the account information page
    When the user selects a gender and verify the name and email
    And the user sets a password, select Data of Birth, check the Sign up for our newsletter box
    And the user enters firstname,lastname,company,address,selects country,state,city,zipcode and mobile number
    Then the user clicks on Create Account and account should be successfully created