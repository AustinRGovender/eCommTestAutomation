@Products
Feature: Products Page

  Scenario: View product details
    Given I am on the Products page
    When I click on a product
    Then I should see a product details modal
