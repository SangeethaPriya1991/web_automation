
Feature: User verify and place the order

  Scenario: User validates and checkout the products and place the order
    Given the user is on the cart listing page
    Then each product should be present in the cart with the correct quantity
      | ProductName                 | Quantity |
      | Stylish Dress               | 2        |
      | Sleeves Printed Top - White | 3        |
      | Frozen Tops For Kids        | 4        |

    When the user click on Proceed to checkout button
    And click on Place Order button
    Then Payment page should display