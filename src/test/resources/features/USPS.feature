@USPS
Feature: USPS testing



  @USPS1
  Scenario: Lookup ZIP
    Given I go to "usps" page new
    Then I click Mail&Ship
    And I click Lookup a ZIP Code
    And I click Find by Address
    Then I fill out Form
    Then I verify that my ZIP code is in the list

  @USPS2
  Scenario: Calculate price
    Given I go to "usps" page new
    When I go to Calculate Price Page
    And I select "United Kingdom" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.30"

