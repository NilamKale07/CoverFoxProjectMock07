Feature: Study Data Table

  Scenario: Test gmail Logins
    Given I am on login pages
    When I provide details and click on login button
      | userName | password | msg       |
      | test@123 | 12345    | welcome    |
      | ram@789  | 7896     | Thank you |
    Then I should navigate to inboxs
