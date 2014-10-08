Feature: daily test load member 08 Active

  Scenario: check links under My details
    Given I open browser "firefox"
    And I navigate to Login Page
    Then I login as superuser
    Then I load member "BPF-0122398"
    When I click to "My details" link
    And I should see "This is me" link
    And I should see "Scheme pays" link
    And I should see "My Annual Allowance" link
    And I should see "My Carry Forward" link
    And I should see "My Benefits" link
    And I should see "My retirement" link
    And I should see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My benefits" link

  Scenario: continue check this is me page
    Then I click to "This is me" link
    And I should see the refno "0122398" existed in This is Me page

  Scenario: continue check link under My Benefits
    Then I click to "My Benefits" link
    And I should see "Scheme benefits" link
    And I should see "State benefits" link

  Scenario: continue check Scheme benefits page
    Then I click to "Scheme benefits" link
    Then I should see the refno "0122398" existed in Scheme benefits page
    And I should see the nino number existed in Scheme benefits page

  Scenario: continue check State benefits page
    Then I click to "State benefits" link
    Then I should see the date of birth and the nino number should existed in State benefits page

  Scenario: continue model My retirement page
    Then I click to "My retirement" link
    Then I model Retirement Age
    Then I model Cash Lump Sum
    Then I model Contributory Options

  Scenario: continue model Redundancy page
    Then I click to "Redundancy" link
    Then I model model Redundancy

  Scenario: continue check My Annual Allowance page
    Then I click to "My Annual Allowance" link
    And I should see "AA Pension savings" link
    And I should see "My AA Statement" link
    And I should not see "My AA Projection" link

  Scenario: continue check My carry forward page
    Then I click to "My Carry Forward" link
    Then I logout
    Then I quit the browser
