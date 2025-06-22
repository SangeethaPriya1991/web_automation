Feature: Select product and add to cart


  Scenario: User selects multiple products and add them to the cart
    Given the user is on the product listing page
    When the user adds the following products to the cart:
      | ProductName                 | Quantity |
      | Stylish Dress               | 2        |
      | Sleeves Printed Top - White | 3        |
      | Frozen Tops For Kids        | 4        |
    Then each product should be added to the cart successfully


