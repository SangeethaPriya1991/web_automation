Feature: Fill the payment details

  Scenario: Enter the user payment details
    Given the user is on the payment page
    When user should enters card name,card number, cvc, expiry month and expiry year
    And the user clicks on submit page
    Then the user should see the confirmation message