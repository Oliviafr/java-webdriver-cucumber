@java
Feature: Java feature

  @java1
  Scenario: Java steps
    Given I say hello world

  @java2
  Scenario: Strings
    Given I act on "my var" and "MY VAR"

  @java3
  Scenario: Comparison
    Given I compare "Los Altos" and "Los Altos"

  @java4
  Scenario: Urls
    Given I print url for "swisscows" page

  @java5
  Scenario: Array example
    Given I work with arrays

  @java6
  Scenario: Map example
    Given I work with maps

  @java7
  Scenario: Coding challenge
    Given I swap variables
    And I print numbers

  @java8
  Scenario: HashMap
    Given I find the number with most occurrences in array, output should be this number. Try using hashmap
#    Examples:
#      | data                |
#      | 1,2,2,3,3,3,4,5,6,7 |
