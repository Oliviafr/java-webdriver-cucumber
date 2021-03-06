@quote
  Feature: Quote form

    @quote1
      Scenario: Verify that Application Section Desktop
        Given I open url "https://skryabin.com/market/quote.html"
        When I resize window to 1280 and 1024
        Then I wait for 5 sec
        Then element with xpath "//b[@id='location']" should be displayed
        Then element with xpath "//b[@id='currentDate']" should be displayed
        Then element with xpath "//b[@id='currentTime']" should be displayed

    @quote2
      Scenario: Verify that Application Section Tablet
        Given I open url "https://skryabin.com/market/quote.html"
        When I resize window to 1000 and 1024
        Then element with xpath "//b[@id='location']" should be displayed
        Then element with xpath "//b[@id='currentDate']" should be displayed
        Then element with xpath "//b[@id='currentTime']" should be displayed

    @quote3
      Scenario: Verify that Application Section Phone
        Given I open url "https://skryabin.com/market/quote.html"
        When I resize window to 600 and 1024
        Then element with xpath "//b[@id='location']" should not be displayed
        Then element with xpath "//b[@id='currentDate']" should not be displayed
        Then element with xpath "//b[@id='currentTime']" should not be displayed

    @quote4
      Scenario: Validate “Username” field
        Given I open url "https://skryabin.com/market/quote.html"
        When element with xpath "//input[@name='username']" should be present
        Then I type "a" into element with xpath "//input[@name='username']"
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='username-error']" should be displayed
        Then I clear element with xpath "//input[@name='username']"
        Then I type "ab" into element with xpath "//input[@name='username']"
        Then I wait for 5 sec
        Then element with xpath "//label[@id='username-error']" should not be displayed


    @quote5
      Scenario: Validate “Email” field behavior
        Given I open url "https://skryabin.com/market/quote.html"
        When element with xpath "//input[@name='email']" should be present
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then I wait for 5 sec
        Then element with xpath "//label[@id='email-error']" should be displayed
        Then I type "rrrrr" into element with xpath "//input[@name='email']"
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then I wait for 5 sec
        Then element with xpath "//label[@id='email-error']" should be displayed
        Then I clear element with xpath "//input[@name='email']"
        Then I type "test@dddd.com" into element with xpath "//input[@name='email']"
        Then element with xpath "//label[@id='email-error']" should not be displayed


   @quote6
      Scenario: Fill out and validate “Password” set of fields
        Given I open url "https://skryabin.com/market/quote.html"
        When element with xpath "//input[@name='password']" should be present
        Then I type "1234" into element with xpath "//input[@name='password']"
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='password-error']" should be displayed
        Then element with xpath "//*[text()='Please enter at least 5 characters.']" should be displayed
        Then I type "12345" into element with xpath "//input[@name='password']"
        Then I type "1234" into element with xpath "//input[@name='confirmPassword']"
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//*[text()='Please enter at least 5 characters.']" should be displayed
        Then I wait for 5 sec
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then I type "12346" into element with xpath "//input[@name='confirmPassword']"
        Then element with xpath "//*[text()='Passwords do not match!']" should be displayed
        Then I clear element with xpath "//input[@name='confirmPassword']"
        Then I type "123412345" into element with xpath "//input[@name='confirmPassword']"
        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='password-error']" should not be displayed
        Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed

      Scenario: Validate that Confirm Password is disabled if Password field is empty
        Given I open url "https://skryabin.com/market/quote.html"
        When element with xpath "//input[@name='password']" should be present
        Then element with xpath "//input[@name='password']" should have attribute "value" as ""
        Then element with xpath "//input[@name='confirmPassword']" should be displayed

    @quote7
      Scenario: Validate “Name” field behavior
        Given I open url "https://skryabin.com/market/quote.html"
        When I click on element using JavaScript with xpath "//input[@name='name']"
        When element with xpath "//div[@role='dialog']" should be present
        Then I click on element using JavaScript with xpath "(//div[@class='ui-dialog-buttonset']/button)[2]"
        Then element with xpath "//input[@name='name']" should have attribute "value" as ""
        When I click on element using JavaScript with xpath "//input[@name='name']"
        Then I type "Ötto" into element with xpath "//input[@id='firstName']"
        And I type "Greg" into element with xpath "//input[@id='middleName']"
        And I type "Kochler" into element with xpath "//input[@id='lastName']"
        Then I click on element using JavaScript with xpath "(//div[@class='ui-dialog-buttonset']/button)[1]"
        Then I wait for 5 sec
        Then element with xpath "//input[@name='name']" should have attribute "value" as "Ötto Greg Kochler"

    @quote8
      Scenario: Validate that Accepting Privacy Policy is required
        Given I open url "https://skryabin.com/market/quote.html"
        When I click on element using JavaScript with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
        Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
        Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

    @quote9
      Scenario: Entering non-required fields in the order -
      Phone Number
      Country of Origin
      Gender
      Allowed to Contact?
      Address
      Car Make
      3rd party agreement acceptance
      Date of Birth
        Given I open url "https://skryabin.com/market/quote.html"
        Then element with xpath "//input[@name='phone'][@type='number']" should be present
        Then I type int "1113338888" into element with xpath "//input[@name='phone'][@type='number']"
        Then I click on element using JavaScript with xpath "//select[@name='countryOfOrigin']/option[@value='Monaco']"
        Then I click on element using JavaScript with xpath "//*[@name='gender'][@value='female']"
        Then I click on element using JavaScript with xpath "//*[@name='allowedToContact']"
        Then I type "Graben 28 Suite 1a2b3c " into element with xpath "//*[@id='address']"
        Then I click on element using JavaScript with xpath "//option[contains(text(),'Toyota')]"
        Then I click on element using JavaScript with xpath "//*[@id='thirdPartyButton']"
        Then I accept alert
        Then I click on element using JavaScript with xpath "//label[contains(text(),'Date of Birth')]"
        Then I wait for 1 sec
        Then I wait for element with xpath "//div[@id='ui-datepicker-div']" to be present
        Then I click on element using JavaScript with xpath "//select[@class='ui-datepicker-year']/option[@value='1899']"
        Then I click on element using JavaScript with xpath "//select[@class='ui-datepicker-month']/option[@value='6']"
        Then I click on element using JavaScript with xpath "//a[contains(text(),'31')]"

#    @quote9
#      Scenario: Submit the form and verify the data and validate that after form submission entered fields values are present on the page
#        Given I open url "https://skryabin.com/market/quote.html"
#        Then I type "Ötto" into element with xpath "//input[@name='username']"
#        Then I type "test@dddd.com" into element with xpath "//input[@name='email']"
#        Then I type "123412345" into element with xpath "//input[@name='password']"
#        Then I type "123412345" into element with xpath "//input[@name='confirmPassword']"
#        When I click on element using JavaScript with xpath "//input[@name='name']"
#        Then I type "Ötto" into element with xpath "//input[@id='firstName']"
#        And I type "Greg" into element with xpath "//input[@id='middleName']"
#        And I type "Kochler" into element with xpath "//input[@id='lastName']"
#        Then I click on element using JavaScript with xpath "(//div[@class='ui-dialog-buttonset']/button)[1]"
#        Then element with xpath "//input[@name='phone'][@type='number']" should be present
#        Then I type int "1113338888" into element with xpath "//input[@name='phone'][@type='number']"
#        Then I wait for 5 sec
#        Then I click on element using JavaScript with xpath "//select[@name='countryOfOrigin']"
#        Then I click on element using JavaScript with xpath "//select[@name='countryOfOrigin']/option[@value='Monaco']"
#        Then I wait for 5 sec
#        Then I click on element using JavaScript with xpath "//*[@name='gender'][@value='female']"
#        Then I click on element using JavaScript with xpath "//*[@name='allowedToContact']"
#        Then I type "Graben 28 Suite 1a2b3c " into element with xpath "//*[@id='address']"
#        Then I click on element using JavaScript with xpath "//option[contains(text(),'Toyota')]"
#        Then I click on element using JavaScript with xpath "//*[@id='thirdPartyButton']"
#        Then I accept alert
#        Then I click on element using JavaScript with xpath "//label[contains(text(),'Date of Birth')]"
#        Then I wait for 1 sec
#        Then I wait for element with xpath "//div[@id='ui-datepicker-div']" to be present
#        Then I click on element using JavaScript with xpath "//a[@class='ui-datepicker-prev ui-corner-all'][@data-handler='prev'][1]"
##        Then I click on element using JavaScript with xpath "//a[contains(text(),'31')]"
#        Then I click on element using JavaScript with xpath "//*[@class=' ui-datepicker-week-end ']/a[contains(text(),'6')]"
#        Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
#        Then I wait for 5 sec
#        Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
#        Then I wait for 5 sec
#        Then element with xpath "//b[@name='username'][contains(text(),'Ötto')]" should be displayed
#        Then element with xpath "//b[@name='firstName'][contains(text(),'Ötto')]" should be displayed
#        Then element with xpath "//b[@name='name'][contains(text(),'Ötto Greg Kochler')]" should be displayed
#        Then I wait for 5 sec
#        Then element with xpath "//b[@name='countryOfOrigin'][contains(text(),'Monaco')]" should be displayed
#        Then element with xpath "//b[@name='carMake'][contains(text(),'Toyota')]" should be displayed
#        Then element with xpath "//b[@name='currentDate'][contains(text(),'07/18/2019')]" should be displayed
#        Then element with xpath "//b[@name='email'][contains(text(),'test@dddd.com')]" should be displayed
#        Then element with xpath "//b[@name='lastName'][contains(text(),'Kochler')]" should be displayed
#        Then element with xpath "//b[@name='phone'][contains(text(),'1113338888')]" should be displayed
#        Then element with xpath "//b[@name='gender'][contains(text(),'female')]" should be displayed
#        Then element with xpath "//b[@name='agreedToPrivacyPolicy'][contains(text(),'true')]" should be displayed
#        Then element with xpath "//b[@name='currentTime'][contains(text(),'Pacific Daylight Time')]" should be displayed
#        Then element with xpath "//b[@name='password'][contains(text(),'[entered]')]" should be displayed
#        Then element with xpath "//b[@name='middleName'][contains(text(),'Greg')]" should be displayed
#        Then element with xpath "//b[@name='dateOfBirth'][contains(text(),'06/16/2019')]" should be displayed
#        Then element with xpath "//b[@name='allowedToContact'][contains(text(),'true')]" should be displayed
#        Then element with xpath "//b[@name='location'][contains(text(),'Los Altos, CA 94022')]" should be displayed
#        Then element with xpath "//b[@name='thirdPartyAgreement'][contains(text(),'accepted')]" should be displayed

    @quote10
    Scenario: Submit the form and verify the data and validate that after form submission entered fields values are present on the page
      Given I open url "https://skryabin.com/market/quote.html"
      Then I type "Ötto" into element with xpath "//input[@name='username']"
      Then I type "test@dddd.com" into element with xpath "//input[@name='email']"
      Then I type "123412345" into element with xpath "//input[@name='password']"
      Then I type "123412345" into element with xpath "//input[@name='confirmPassword']"
      When I click on element using JavaScript with xpath "//input[@name='name']"
      Then I type "Ötto" into element with xpath "//input[@id='firstName']"
      And I type "Greg" into element with xpath "//input[@id='middleName']"
      And I type "Kochler" into element with xpath "//input[@id='lastName']"
      Then I click on element using JavaScript with xpath "(//div[@class='ui-dialog-buttonset']/button)[1]"
      Then element with xpath "//input[@name='phone'][@type='number']" should be present
      Then I type int "1113338888" into element with xpath "//input[@name='phone'][@type='number']"
      Then I click on element with xpath "//*[contains(text(),'Monaco')]"
      Then I wait for 1 sec
      Then I click on element using JavaScript with xpath "//*[@name='gender'][@value='female']"
      Then I click on element using JavaScript with xpath "//*[@name='allowedToContact']"
      Then I type "Graben 28 Suite 1a2b3c " into element with xpath "//*[@id='address']"
      Then I click on element with xpath "//*[contains(text(),'Toyota')]"
      Then I wait for 5 sec
      Then I click on element using JavaScript with xpath "//*[@id='thirdPartyButton']"
      Then I accept alert
      Then I click on element using JavaScript with xpath "//label[contains(text(),'Date of Birth')]"
      Then I wait for 1 sec
      Then I wait for element with xpath "//div[@id='ui-datepicker-div']" to be present

      And I click on element with xpath "//select[@data-handler='selectMonth']/option[11]"
      And I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1981']"
      And I click on element with xpath "//td[@data-handler='selectDay']/a[text()='17']"
      And element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "11/17/1981"
      Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      Then I wait for 2 sec
      Then I click on element using JavaScript with xpath "//button[@id='formSubmit']"
      Then I wait for 2 sec
      Then element with xpath "//b[@name='username'][contains(text(),'Ötto')]" should be displayed
      Then element with xpath "//b[@name='firstName'][contains(text(),'Ötto')]" should be displayed
      Then element with xpath "//b[@name='name'][contains(text(),'Ötto Greg Kochler')]" should be displayed
      Then element with xpath "//b[@name='countryOfOrigin'][contains(text(),'Monaco')]" should be displayed
      Then element with xpath "//b[@name='carMake'][contains(text(),'Toyota')]" should be displayed
#    Should be dynamic date (date.today)
      Then element with xpath "//b[@name='currentDate']" should contain text from function
#      Then element with xpath "//b[@name='currentDate'][contains(text(),'07/21/2019')]" should be displayed
      Then element with xpath "//b[@name='email'][contains(text(),'test@dddd.com')]" should be displayed
      Then element with xpath "//b[@name='lastName'][contains(text(),'Kochler')]" should be displayed
      Then element with xpath "//b[@name='phone'][contains(text(),'1113338888')]" should be displayed
      Then element with xpath "//b[@name='gender'][contains(text(),'female')]" should be displayed
      Then element with xpath "//b[@name='agreedToPrivacyPolicy'][contains(text(),'true')]" should be displayed
#    Should be dynamic time (time.now)
      Then element with xpath "//b[@name='currentTime'][contains(text(),'Pacific Daylight Time')]" should be displayed
      Then element with xpath "//b[@name='password'][contains(text(),'[entered]')]" should be displayed
      Then element with xpath "//b[@name='middleName'][contains(text(),'Greg')]" should be displayed
      Then element with xpath "//b[@name='dateOfBirth'][contains(text(),'11/17/1981')]" should be displayed
      Then element with xpath "//b[@name='allowedToContact'][contains(text(),'true')]" should be displayed
      Then element with xpath "//b[@name='location'][contains(text(),'Los Altos, CA 94022')]" should be displayed
      Then element with xpath "//b[@name='thirdPartyAgreement'][contains(text(),'accepted')]" should be displayed


#    @quote9
#      Scenario: Date
#        Given the date of Given today is
#        Given today is

#  Slava's scenarious

#    @quote
#    Feature: Quote form
#
#    @quote1
#    Scenario: Quote responsive design
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I resize window to 1280 and 1024
#      Then element with xpath "//b[@id='location']" should be displayed
#      Then element with xpath "//b[@id='currentDate']" should be displayed
#      Then element with xpath "//b[@id='currentTime']" should be displayed
#      When I resize window to 1000 and 1024
#      Then element with xpath "//b[@id='location']" should be displayed
#      Then element with xpath "//b[@id='currentDate']" should be displayed
#      Then element with xpath "//b[@id='currentTime']" should be displayed
#      When I resize window to 600 and 1024
#      Then element with xpath "//b[@id='location']" should not be displayed
#      Then element with xpath "//b[@id='currentDate']" should not be displayed
#      Then element with xpath "//b[@id='currentTime']" should not be displayed
#      When I resize window to 1280 and 1024
#
#    @quote2 @smoke
#    Scenario: Username field
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I type "a" into element with xpath "//input[@name='username']"
#      And I click on element using JavaScript with xpath "//button[@id='formSubmit']"
#      Then element with xpath "//label[@id='username-error']" should be displayed
#      When I type "b" into element with xpath "//input[@name='username']"
#      Then element with xpath "//label[@id='username-error']" should not be displayed
#
#    @quote3 @smoke
#    Scenario: Email field
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I type "slavaskryabin.com" into element with xpath "//input[@name='email']"
#      And I click on element using JavaScript with xpath "//button[@id='formSubmit']"
#      Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
#      And I clear element with xpath "//input[@name='email']"
#      When I type "slava@skryabin.com" into element with xpath "//input[@name='email']"
#      Then element with xpath "//label[@id='email-error']" should not be displayed
#
#    @quote4
#    Scenario: Password field
#      Given I open url "https://skryabin.com/market/quote.html"
#      Then element with xpath "//input[@id='password']" should have attribute "value" as ""
#      Then element with xpath "//input[@id='confirmPassword']" should be disabled
#      When I type "password" into element with xpath "//input[@id='password']"
#      Then element with xpath "//input[@id='confirmPassword']" should be enabled
#
#    @quote5
#    Scenario: Name
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I click on element with xpath "//input[@id='name']"
#      Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
#      And I type "Slava" into element with xpath "//input[@id='firstName']"
#      And I type "Skryabin" into element with xpath "//input[@id='lastName']"
#      When I click on element with xpath "//span[text()='Save']"
#      Then element with xpath "//input[@id='name']" should have attribute "value" as "Slava Skryabin"
#
#    @quote6
#    Scenario: Datepicker
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I click on element with xpath "//input[@id='dateOfBirth']"
#      And I click on element with xpath "//select[@data-handler='selectMonth']/option[11]"
#      And I click on element with xpath "//select[@data-handler='selectYear']/option[@value='1981']"
#      And I click on element with xpath "//td[@data-handler='selectDay']/a[text()='17']"
#      And element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "11/17/1981"

#







  










