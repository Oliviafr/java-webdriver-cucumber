@converters
Feature: Converters functions

  @converters1
  Scenario Outline: Validate Fahrenheit to Celsius
    Given I go to "converter" page new
#    When I click on "Temperature"
    When I click on "<tab>"
    And I set "<from>" to "<to>"
    Then I enter into From field "<fromValue>" and verify "<toValue>" result
    Examples:
      | tab         | from       | to       | fromValue | toValue |
      | Temperature | Fahrenheit | Celsius  | 54        | 12.2    |
      | Weight      | Pound      | Kilogram | 170       | 77      |
      | Length      | Mile       | Kilometer| 50        | 80.4    |


