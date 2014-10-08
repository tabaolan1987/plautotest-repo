Feature: daily test load member 04 pensioner

  Scenario: check links under My Details page
    Given I open browser "firefox"
    And I navigate to Login Page
    Then I login as superuser
    Then I load member "BCF-0001532"
    When I click to "My details" link
    And I should see "This is me" link
    And I should see "Scheme pays" link
    And I should see "My benefits" link
    And I should not see "My retirement" link
    And I should not see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My Annual Allowance" link
    And I should not see "My Carry Forward" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My Benefits" link

  Scenario: continue check this is me page
    Then I click to "This is me" link
    And I should see the refno "0001532" existed in This is Me page

  Scenario: continue check My benefits link
    Then I click to "My benefits" link
    Then I should see refno "0001532" existed in My benefits page
    And I should see data loaded successful in My benefits page
    Then I logout
    Then I quit the browser
