
Feature: feature to test login functionality

  Background:
    Given I am on the Automation Exercise page

 Scenario Outline: : Unsuccessfully login with invalid credential
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error-message>"

    Examples:
      | username          | password        |
      | invalid@email.com | invalidpassword |
      | Sarah@example.com | abccc           |

  Scenario Outline: User enters an invalid email without '@'
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then the email field should show a validation error


    Examples:
      | username | password  |
      | abcccc   | sarah123# |

  Scenario: Successfully login with valid credentials
    Given I have entered valid username and password
    When I click on the login button
    Then I should be logged in successfully


