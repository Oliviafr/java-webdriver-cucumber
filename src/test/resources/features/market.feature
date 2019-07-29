@market
Feature: Marketing app

  @market1
  Scenario: Base scenario
    Given I open quote page
#    And I print page details
    And I print page title
    And I print window handles
    When I fill out required fields
    And I submit the form
    Then I verify the info in the form
    Then I verify the info with assert

  @market2
  Scenario: Navigation
    Given I go to "quote" page
    And I go to "google" page
    Then I go back and forward,then refresh the page
    Then I change resolution to phone
    Then I change resolution to desktop

#  @market3
#    Then I go back and forward,then refresh the page "google"







