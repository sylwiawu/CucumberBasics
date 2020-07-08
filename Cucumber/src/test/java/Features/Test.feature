Feature: Example

  Scenario: Add products to basket
    Given I am on product site
    When I click on add to cart
    Then Product is added to cart

  Scenario: Login to existing account
    Given I am on a login site
    When I enter my credentials
    And I click sign in
    Then Logged user is "Bruce Wayne"

  Scenario: Searching for dress
    Given I am on main site
    When I type "Dress" in search bar
    And I click enter
    Then Result found shown for "DRESS"