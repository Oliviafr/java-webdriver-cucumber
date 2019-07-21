@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I wait for 5 sec
    Then I click on element using JavaScript with xpath "(//input[@value='Google Search'])[2]"
    Then I wait for element with xpath "//div[@id='res']" to be present
    Then element with xpath "//div[@id='res']" should contain text "Cucumber"

#  @predefined2 @smoke
#  Scenario: Predefined steps for Bing
#    Given I open url "https://www.bing.com"
#    Then I should see page title as "Bing"
#    Then element with xpath "//input[@name='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
#    Then I click on element using JavaScript with xpath "//input[@id='sb_form_go']"
#    Then I wait for element with xpath "//ol[@id='b_results']" to be present
#    Then element with xpath "//ol[@id='b_results']" should contain text "BDD"
#
#  @predefined3 @smoke
#  Scenario: Predefined steps for Yahoo
#    Given I open url "https://yahoo.com"
#    Then I should see page title as "Yahoo"
#    Then element with xpath "//input[@id='uh-search-box']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@id='uh-search-box']"
#    Then I click on element with xpath "//*[@class='Fz(26px) Mstart(2px) Icon-Fp2 IconNavSearch Icon-Fp2']"
#    Then I wait for element with xpath "//div[@id='left']" to be present
#    Then element with xpath "//div[@id='left']" should contain text "Behavior Driven Development"
#
#  @predefined4 @smoke
#  Scenario: Predefined steps for Gibiru
#    Given I open url "https://gibiru.com"
#    Then I should see page title contains "Gibiru"
#    Then element with xpath "//input[@name='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
#    Then I click on element with xpath "//button[@id='button-addon2']"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@class='gsc-control-wrapper-cse']" to be present
#    Then element with xpath "//div[@class='gsc-control-wrapper-cse']" should contain text "Behavior Driven Development"
#
#  @predefined5 @smoke
#  Scenario: Predefined steps for Duckduckgo
#    Given I open url "https://duckduckgo.com"
#    Then I should see page title contains "DuckDuckGo"
#    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
#    Then I click on element using JavaScript with xpath "//input[@id='search_button_homepage'][@type='submit']"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@id='links_wrapper']" to be present
#    Then element with xpath "//div[@id='links_wrapper']" should contain text "Behavior-driven development"
#
#
#  @predefined6 @smoke
#  Scenario: Predefined steps for Swisscows
#    Given I open url "https://swisscows.com"
#    Then I should see page title contains "Swisscows"
#    Then element with xpath "//input[@name='query']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
#    Then I click on element using JavaScript with xpath "//button[@class='search-submit']"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@class='cloud-container']" to be present
#    Then element with xpath "//div[@class='cloud-container']" should contain text "BDD"
#    And element with xpath "//div[@class='cloud-container']" should contain text "Development"
#    And element with xpath "//div[@class='cloud-container']" should contain text too "Behavior"
#    And element with xpath "//div[@class='cloud-container']" should contain text too "Driven"
#    Then I click on element using JavaScript with xpath "//*[@class='cloud-menu']/div[@class='button-toggle']/div[@class='knobs']"
#    Then I wait for 3 sec
#    Then element with xpath "//*[@title='<b>Behavior-driven development</b> - <b>Wikipedia</b>']" should contain text "Behavior-driven development"
#
#  @predefined7 @smoke
#  Scenario: Predefined steps for Startpage
#    Given I open url "https://www.startpage.com"
#    Then I should see page title contains "Startpage"
#    Then element with xpath "//input[@id='query']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@id='query']"
#    Then I click on element using JavaScript with xpath "//button[@class='search-form__button']"
#    Then I wait for 5 sec
#    Then I switch to iframe with xpath "//iframe[@frameborder='0'][@title='Sponsored Links']"
#    Then I wait for element with xpath "//*[contains(text(),'behavior driven development')]" to be present
#
#
#  @predefined8 @smoke
#  Scenario: Predefined steps for Yandex
#    Given I open url "https://www.yandex.com"
#    Then I should see page title contains "Yandex"
#    Then element with xpath "//input[@id='text']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
#    Then I click on element using JavaScript with xpath "//div[@class='search2__button']/button"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@class='main__center']" to be present
#    Then element with xpath "//div[@class='main__center']" should contain text "Behavior"
#    And element with xpath "//div[@class='main__center']" should contain text too "Driven"
#    And element with xpath "//div[@class='main__center']" should contain text too "Development"
#
#  @predefined9 @smoke
#  Scenario: Predefined steps for Boardreader
#    Given I open url "http://boardreader.com"
#    Then I wait for element with xpath "//img[@alt='BoardReader'][1]" to be present
#    Then element with xpath "//input[@id='title-query']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
#    Then I wait for 3 sec
#    Then I click on element using JavaScript with xpath "//button[@value='Go']"
#    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
#    Then I wait for element with xpath "//div[@class='mdl-grid mdl-grid--no-spacing'][1]" to be present
#    Then I wait for 3 sec
#    Then element with xpath "//div[@class='mdl-grid mdl-grid--no-spacing'][1]" should contain text "Behavior-Driven Development"
#
#
#  @predefined10 @smoke
#  Scenario: Predefined steps for Ecosia
#    Given I open url "https://www.ecosia.org"
#    Then I should see page title contains "Ecosia"
#    Then element with xpath "//input[@name='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
#    Then I click on element using JavaScript with xpath "//button[@type='submit'][@icon='search']"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@class='result-wrapper']" to be present
#    Then element with xpath "//div[@class='result-wrapper']" should contain text "Behavior-driven development"
#
#
#  @predefined11 @smoke
#  Scenario: Predefined steps for Searchencrypt
#    Given I open url "https://www.searchencrypt.com"
#    Then I wait for element with xpath "//img[@src='/Content/branding/searchencrypt/img/main-logo.png']" to be present
#    Then I wait for 5 sec
#    Then element with xpath "(//div[@class='search-box input-group input-group-lg']//input[@name='q'])[2]" should be present
#    When I type "Behavior Driven Development" into element with xpath "(//div[@class='search-box input-group input-group-lg']//input[@name='q'])[2]"
#    Then I click on element using JavaScript with xpath "(//*[@id='btn-secure-search'])[2]"
#    Then I wait for 5 sec
#    Then I wait for element with xpath "//div[@id='container-wrapper']" to be present
#    Then element with xpath "//div[@id='container-wrapper']" should contain text "Behavior"
#    And element with xpath "//div[@id='container-wrapper']" should contain text too "Driven"
#    And element with xpath "//div[@id='container-wrapper']" should contain text too "Development"
#
#
