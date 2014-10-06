Feature: daily test load member 01 Walled

  Scenario: Load member and check link under my detail with Firefox browser
    Given I open browser "firefox"
    And I navigate to "Login Page"
    Then I login as superuser
    Then I load member "BPF-0103603"
    Then I click to "My details" link
    And I should not see "This is me" link
    And I should not see "My retirement" link
    And I should not see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My Annual Allowance" link
    And I should not see "My Carry Forward" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My Benefits" link
    And I should not see "My benefits" link
    And I should not see "Scheme pays" link
    Then I quit the browser

  Scenario: Load member and check link under my detail with chrome browser
    Given I open browser "chrome"
    And I navigate to "Login Page"
    Then I login as superuser
    Then I load member "BPF-0103603"
    Then I click to "My details" link
    And I should not see "This is me" link
    And I should not see "My retirement" link
    And I should not see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My Annual Allowance" link
    And I should not see "My Carry Forward" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My Benefits" link
    And I should not see "My benefits" link
    And I should not see "Scheme pays" link
    Then I quit the browser

  Scenario: Load member and check link under my detail with ie browser
    Given I open browser "ie"
    And I navigate to "Login Page"
    Then I login as superuser
    Then I load member "BPF-0103603"
    Then I click to "My details" link
    And I should not see "This is me" link
    And I should not see "My retirement" link
    And I should not see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My Annual Allowance" link
    And I should not see "My Carry Forward" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My Benefits" link
    And I should not see "My benefits" link
    And I should not see "Scheme pays" link
    Then I quit the browser
