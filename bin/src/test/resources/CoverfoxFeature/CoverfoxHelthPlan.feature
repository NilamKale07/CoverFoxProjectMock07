Feature: Coverfox Health Insurance Test
Scenario: TC01 Validate Coverfox Health Insurance for single person with parameters
Given I am on home page
When I click on getStarted button
And I click on next button
And I Provide age as "30" and click on next button
And I provide pincode as "410210",mobile number as "7977868014" and click on continue button
Then Matching Health Insurance plans should be displayed as "47"

Scenario: TC02 validate coverfox address details page error messges
Given I am on home page
When I click on getStarted button
And I click on next button
And I Provide age as "30" and click on next button
And I provide pincode and click on continue button
Then Validate Error message