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
    Given I go to "yahoo" page
    Given I print console logs
#    Then I wait for 1 sec

  @java11
  Scenario: SortArray
    Given I sort my Array

  @java12
  Scenario: Timenow
    Given I print time now "2:35"


  @java13
    Scenario: Array sum 0
      Given I print array with sum zero for 5


  @java14
      Scenario: Coding challenge
        Given I swap variables


  @java15
        Scenario: Coding challenge 2
          Given Create an array mult of 10

  @java16
          Scenario: Coding challenge 3
            Given I print console logs

#  3) Coding challenges
#  a) Write the code to exchange first and last numbers in an array
#  b) Could you write a loop even numbers from 1-10 in any language?
#  c) Write the code to print the characters from 3rd position to 8th in a string

  @java17
  Scenario: Coding challenge 4
    Given I write the code to exchange first and last numbers in an array

  @java18
    Scenario: Coding challenge 5
      Given I write a loop even numbers from 1 to 10

  @java19
      Scenario: Coding challenge 6
        Given I write the code to print the characters from 3rd position to 8th in a string











