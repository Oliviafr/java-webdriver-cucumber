@careers
Feature: Careers Test Suite

  @careers1
  Scenario: Careers scenario
    Given I go to "careers" page oop
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create "automation" requisition
    And I verify "automation" position created

  @careers2
  Scenario: Careers candidate
    Given I go to "careers" page oop
    And I apply to "automation" position for "candidate"
    Then I verify "candidate" profile is created
    And I see "automation" position in my jobs


  @careers3 @rest1
  Scenario: REST API Position CRUD
    Given I login to REST API as "recruiter"
    When I create via REST API "automation" position
    Then I verify via REST API position is created
    When I update via REST API "title" position
    Then I verify via REST API position updated
    And I delete via REST API created position


  @careers4 @rest2
  Scenario: REST API Candidate CRUD
    Given I login to REST API as "candidate"
    When I create via REST API "automation" position
    Then I verify via REST API position is created
    When I update via REST API "title" position
    Then I verify via REST API position updated
    And I delete via REST API created position
