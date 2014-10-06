Feature: daily test load member 02 Deferred
  
  Scenario : Load member and check link
    Given I open browser "firefox"
  Then I navigate to "Login page"
  Then I login as superuser
  Then I load member "BPF-0103360"
  Then I click to "My details" link
  	And I should see "This is me" link
  	And I should see "Scheme pays" link
  	And I should not see "My retirement" link
    And I should not see "Redundancy" link
    And I should not see "My Accrual Rate" link
    And I should not see "My Annual Allowance" link
    And I should not see "My Carry Forward" link
    And I should not see "My LifeTime Allowance" link
    And I should not see "My Benefits" link
    And I should not see "My benefits" link
  Then I click to "This is me" link
  And I should see the refno in table personal detail
   Then I quit the browser
