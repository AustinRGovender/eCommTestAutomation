@ContactUs
Feature: Contact Us Page

  Scenario: Successfully submit a contact form
    Given I am on the Contact Us page
    When I fill in the contact form with valid data
    And I submit the contact form
    Then I should see a success message
