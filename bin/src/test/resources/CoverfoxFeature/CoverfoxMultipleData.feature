Feature: Coverfox Health Insurance Test

  Scenario Outline: TC01 Validate Coverfox Health Insurance for single person with multiple test data
    Given I am on home page
    When I click on getStarted button
    And I click on next button
    And I Provide age as "<age>" and click on next button
    And I provide pincode as "<pincode>",mobile number as "<mobNo>" and click on continue button
    Then Matching Health Insurance plans should be displayed as "<results>"

    Examples:
      | age | pincode | mobNo      | results |
      | 20  | 410210  | 7977856920 | 90      |
      | 23  | 411210  | 8977856920 | 80      |
      | 33  | 411250  | 9977856920 | 50      |
