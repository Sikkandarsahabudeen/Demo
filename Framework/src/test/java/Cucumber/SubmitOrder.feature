Feature: Submit the Order from outline

  Background:
    Given User landed on login page

  @tag
  Scenario Outline: Successfully order the product
    Given User has logged in the ecommerce website with "<username>" "<password>"
    When I ordered the product "<product>"
    And Check out the submit order "<product>"
    Then Ensure the ordered messages "<message>"

    Examples:
      | username         | password | message                 | product     |
      | dummy2@email.com | Test@123 | Thankyou for the Orde. | ZARA COAT 3 |
