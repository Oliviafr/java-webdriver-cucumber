@careers
Feature: Careers Test Suite

  @careers1
  Scenario: Careers scenario
    Given I go to "careers" page oop
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create "automation" requisition
    And I verify "automation" position created