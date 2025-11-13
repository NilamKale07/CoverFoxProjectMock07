Feature: Coverfox Health Insurance Test
Scenario: TC01 Validate Coverfox Health Insurance plan for single person
Given I am on home page
When I click on getStarted button
And I click on next button
And I Provide age as "30" and click on next button
And I provide pincode as "410210",mobile number as "7977868014" and click on continue button
Then Matching Health Insurance plans should be displayed as "48"

@login
Scenario:: TC02 Validate Coverfox Car Insurance plan
Given I am on home page
When I click on CarInsurance button
And I provide valid RTO number and click on view quotes button
And I provide valid details and click on view quotes button
Then I should get the paln details

@createAccount
Scenario:: TC03 Validate Coverfox Bike Insurance plan
Given I am on home page
When I click on bikeInsurance button
And I provide valid RTO number and click on view quotes button
And I provide valid details and click on view quotes button
Then I should get the paln details