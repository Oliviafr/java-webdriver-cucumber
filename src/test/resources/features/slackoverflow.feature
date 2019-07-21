@slackoverflow
Feature: Slackoverflow form


  @slackoverflow1
  Scenario: Slackoverflow overview
    Given I open url "https://stackoverflow.com/"
    Then I should see page title contains "Stack Overflow"
    When I type "Cucumber with gherkins java" into element with xpath "//input[@name='q']"
    Then I press Return
    Then I wait for 1 sec
    Then I wait for element with xpath "//div[@class='left-sidebar--sticky-container js-sticky-leftnav']" to be present
    Then I wait for element with xpath "//div[@class='-container'][@role='menubar']" to be present
    Then element with xpath "//*[contains(text(),'Search Results')]" should be displayed
    Then element with xpath "//*[contains(text(),'Results for cucumber with gherkins java')]" should be displayed
    Then I click on element using JavaScript with xpath "//button[@class='grid--cell s-btn s-btn__primary']"
    Then element with xpath "//a[@class='pl8 js-gps-track nav-links--link'][contains(text(),'Home')]" should be displayed
    Then element with xpath "//ol[@class='-secondary js-secondary-topbar-links drop-icons-responsively user-logged-out the-js-is-handling-responsiveness']" should be displayed
    Then I wait for 1 sec
    Then element with xpath "//a[contains(text(),'Q: Testing APIs with Gherkin/Java and IntelliJ IDE')]" should be displayed
    Then I wait for 1 sec
    Then element with xpath "//div[@class='grid--cell']" should be displayed
    Then I click on element with xpath "//*[@title='Newest search results']"
    Then element with xpath "//span[contains(text(),'Jul 5')]" should be displayed
    Then I wait for 1 sec
    Then I scroll to the element with xpath "//a[contains(text(),'Q: Cucumber same sentence different scenarios')]" with offset 1
    Then element with xpath "//*[contains(text(),'Cucumber no match gherkin')]" should be displayed
    Then element with xpath "//div[@class='tags user-tags t-java t-cucumber t-cucumber-jvm t-gherkin']" should be displayed
    Then I wait for 1 sec
    Then I click on element with xpath "//*[contains(text(),'Cucumber no match gherkin')]"
    Then I wait for 1 sec
    Then element with xpath "//a[contains(text(),'Cucumber no match gherkin in French if sentence co')]" should be displayed


