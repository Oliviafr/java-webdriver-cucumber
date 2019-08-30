@calculator
  Feature: Calculator functions

    @calculator1
    Scenario Outline: Verify calculator result
      Given I go to "calculator" page new
      When I navigate to "<tab>"
      And I clear all calculator fields
#      And I calculate
#      Then I verify "Please provide a positive auto price." calculator error
#      Then I verify "Please provide a positive interest value." calculator error
#      And I enter "25000" price, "60" months, "4.5" interest, "5000"
#    downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
#      And I calculate
#      Then I verify monthly pay is "$372.86"
      Examples:
        | tab                  |
        | Auto Loan Calculator |
