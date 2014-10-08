Feature: daily test produce report

  Scenario: Check all report and run once of them
    Given I open browser "firefox"
    And I navigate to Login Page
    Then I login as report runner
    Then I click to "Reporting Tool" link
    Then I check all report
    Then I run the report
    Then I check successful report page is shown
    Then I logout
    Then I quit the browser
