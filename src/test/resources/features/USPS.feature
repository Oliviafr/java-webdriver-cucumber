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
  Scenario: UPS end to end
    Given I allow flash
    Given I go to "ups" page new
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment form
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset

  @USPS7
    Scenario: UPS project_2
      Given I go to "ups" page new
      And I open Shipping menu
      And I go to Create a Shipment
      When I fill out second origin shipment form
      And I submit the shipment form
      Then I verify second origin shipment fields submitted
      And  Put sample data to send
      And I submit the shipment form
      And I Select UPS Express Box – Small, "1" pound weight
      And I submit the shipment form
#      Then I verify total charges changed
#      When I submit the shipment form
#      And I select cheapest delivery option
#      And I submit the shipment form
#      And I set Saturday Delivery type
#      Then I verify total charges changed
#      When I submit the shipment form
#      And I select Paypal payment type
#      And I submit the shipment form
#      Then I review all recorded details on the review
#    page
#      And I cancel the shipment form
#      Then I verify shipment form is reset
  @USPS8
    Scenario: PO Box
      Given I go to "usps" page new
      When I go to PO Boxes under Track & Manage
      And I reserve new PO box for "94022"
      Then I verify that "Los Altos — Post Office™" present
      And I verify that "Size 5-XL" PO Box is available in "Los Altos — Post Office™"
