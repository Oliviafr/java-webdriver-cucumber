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

  @USPS3
  Scenario: Wrong store id does not mach
    Given I go to "usps" page new
    When I go to "Postal Store" tab
    And I enter "12345" into store search
    Then I search and validate no products found


  @USPS4
  Scenario: One item found
    Given I go to "usps" page new
    When I go to Stamp and Supplies page
    And I open Stamps
    And choose category Priority Mail
    Then I verify 1 item found in the result

  @USPS5
  Scenario: Verify color
    Given I go to "usps" page new
    When I go to Stamp and Supplies page
    And I open Stamps
    And I open Stamps img
    When I unselect Stamps checkbox
    And select size "Large"
    And I click "blue" color
    Then I verify "Blue" and "Large" filters
    Then I verify "20% OFF" sale

  @USPS6
  Scenario: Verify location
    Given I go to "usps" page new
    When I perform "Passports" search
    And I select "Passport Application" in results
    And I click "Find a Post Office" button
    And I select "94022" zip code within "10 miles" and search
    Then I verify "MOUNTAIN VIEW" present in search results
    When I open "MOUNTAIN VIEW" search results
    Then I verify "211 HOPE ST" address, "9:00am - 12:00pm" appointment hours, "1:00pm - 3:00pm" photo hours
    When I go back to list
    Then I verify I'm on Find Locations search page