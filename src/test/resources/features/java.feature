@java
Feature: Java feature

  @java1
  Scenario: Java steps
    Given I say hello world
    Then I say Hello World One
    Then Print Hello, I'm a student

  @java2
  Scenario: Strings
    Given I act on "my var" and "MY VAR"

  @java3
  Scenario: To compare strings
    Given I would like to compare "string1" with "string2"

  @java4
    Scenario: I Concatenate
      Given  I concatenate "Olivia" and "JAVA"

  @java5
    Scenario: Today date
      Given the date of " "

  @java6
    Scenario: I print url for "site" page
      Given I print url for "quote" page

  @java7
   Scenario: I create array and print it
    Given I print myarr

  @java8
   Scenario: I create array and print it
    Given I print myarr[2] from Array

  @java9
   Scenario: Maps
    Given I work with maps

  @java10
  Scenario: I go to the "site" page
    Given Given I go to "quote" page
    Then I wait for 1 sec

  @java11
  Scenario: SortArray
    Given I sort my Array

  @java12
  Scenario: Timenow
    Given I print time now "2:35"















